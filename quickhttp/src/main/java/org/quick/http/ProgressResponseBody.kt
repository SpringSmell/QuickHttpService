package org.quick.http

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*
import org.quick.async.Async
import org.quick.http.callback.OnProgressCallback

/**
 * 下载进度监听-响应体
 */
class ProgressResponseBody(var builder: HttpService.Builder, var responseBody: ResponseBody, var onProgressCallback: OnProgressCallback?) : ResponseBody() {

    var bufferedSource: BufferedSource

    init {
        bufferedSource = source(responseBody.source()).buffer()
    }

    override fun contentLength(): Long {
        return responseBody.contentLength() + builder.downloadStartIndex
    }

    override fun contentType(): MediaType? = responseBody.contentType()

    override fun source(): BufferedSource {
        return bufferedSource
    }

    private fun source(source: Source): Source {
        return object : ForwardingSource(source) {
            var totalBytesRead = builder.downloadStartIndex
            override fun read(sink: Buffer, byteCount: Long): Long {
                val bytesRead = super.read(sink, byteCount)
                totalBytesRead +=
                    if (bytesRead != -1L)
                        bytesRead
                    else
                        0
                Async.runOnUiThread {
                    onProgressCallback?.onLoading(builder.downloadFileName, totalBytesRead, contentLength(), bytesRead == -1L)
                }
                return bytesRead
            }
        }
    }

}