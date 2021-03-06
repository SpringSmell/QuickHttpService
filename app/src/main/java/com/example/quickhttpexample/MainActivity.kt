package com.example.quickhttpexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quickhttpexample.model.BeanJava2
import com.example.quickhttpexample.model.BeanJavaT
import com.example.quickhttpexample.model.BrandListModel
import kotlinx.android.synthetic.main.activity_main.*
import org.quick.http.HttpService
import org.quick.http.JsonUtils
import org.quick.http.Utils
import org.quick.http.callback.Callback
import org.quick.http.callback.OnDownloadListener
import org.quick.http.callback.OnUploadingListener
import java.io.File
import javax.net.ssl.TrustManager


class MainActivity : AppCompatActivity() {

    val json = "{\n" +
            "            \"name\": \"张三\",\n" +
            "            \"age\": 16,\n" +
            "            \"sex\": true,\n" +
            "            \"mobileNum\": 15102309066\n" +
            "        }"
    var tm = arrayOf<TrustManager>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        config()
        onInit()
        HttpService.Builder("").get()
    }

    fun config() {
        HttpService.Config
            .debug()
            .baseUrl("https://www.baseurl.com")/*默认为空*/
            .addParams("publicTOKEN", "token")/*公共参数*/
            .method(true)/*默认为GET请求*/
            .addHeader("publicHeader", "value")/*公共头部参数*/
            .connectTimeout(200000)/*超时时间*/
            .encoding("UTF-8")/*编码*/
            .retryConnection(true)/*连接异常是否重试：默认为true*/
            .onRequestBefore {
//                it.addHeader("header2", "header1").addParams("test324", "123213")
            }
            .onResponseCallback {
//                Log.e("test", "全局响应 : $it")
            }
            .onFailedCallback { e, isNetError ->
//                Log.e("test", "全局失败")
            }
    }

    fun onInit() {

        tv0.setOnClickListener {
            val json =
                "{\"code\":1,\"data\":{\"next_page\":2,\"datas\":[{\"id\":\"511\",\"tb_brand_name\":\"\\u5f62\\u8c61\\u7f8e\",\"fq_brand_name\":\"\\u5f62\\u8c61\\u7f8e\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/FhGWGLQDnkRmvNZCFwccqTU5UVMw\",\"brandcat\":\"5\",\"introduce\":\"\\u5f62\\u8c61\\u7f8e\\uff0c\\u5efa\\u7acb\\u4e8e2008\\u5e74\\u3002\\u662f\\u4e00\\u4e2a\\u4e13\\u8425\\u62a4\\u80a4\\u5316\\u5986\\u54c1\\u5f00\\u53d1\\u4e0e\\u9500\\u552e\\u7684\\u73b0\\u4ee3\\u5316\\u5de5\\u5382\\u578b\\u4f01\\u4e1a\\u3002 \\u575a\\u6301\\u201c\\u4ee5\\u8bda\\u53d6\\u4fe1\\uff0c\\u4ee5\\u8d28\\u6c42\\u5b58\\u201d\\u7684\\u4f01\\u4e1a\\u5b97\\u65e8\\u3002\\u4f9d\\u6258\\u5148\\u8fdb\\u7684\\u6280\\u672f\\u548c\\u4e25\\u683c\\u7684\\u7ba1\\u7406\\uff0c\\u5168\\u65b9\\u4f4d\\u3001\\u591a\\u5c42\\u6b21\\u7814\\u7a76\\u548c\\u5206\\u6790\\u4e2d\\u56fd\\u7f8e\\u5bb9\\u5316\\u5986\\u54c1\\u5e02\\u573a\\uff0c\\u805a\\u96c6\\u4e86\\u4e00\\u5927\\u6279\\u7ecf\\u9a8c\\u4e30\\u5bcc\\u7684\\u79d1\\u7814\\u3001\\u7ba1\\u7406\\u548c\\u9500\\u552e\\u4eba\\u5458\\uff0c\\u503e\\u529b\\u5173\\u6ce8\\u4e2d\\u56fd\\u6d88\\u8d39\\u8005\\u7684\\u9700\\u6c42\\uff0c\\u4ee5\\u8bda\\u631a\\u4e4b\\u5fc3\\u5411\\u5e7f\\u5927\\u6d88\\u8d39\\u90fd\\u5949\\u732e\\u51fa\\u9ad8\\u54c1\\u8d28\\u7684\\u62a4\\u80a4\\u5316\\u5986\\u54c1\\u3002\\u73b0\\u62e5\\u6709\\u516d\\u5927\\u7efc\\u5408\\u4f18\\u52bf\\uff1a\\u4e13\\u4e1a\\u7684\\u5e02\\u573a\\u8c03\\u7814\\u7cfb\\u7edf\\u3001\\u5468\\u5230\\u7684\\u8425\\u9500\\u7ba1\\u7406\\u7cfb\\u7edf\\u3001\\u6301\\u7eed\\u53d1\\u5c55\\u7684\\u6218\\u7565\\u8def\\u7ebf\\u3001\\u7cbe\\u81f4\\u7684\\u5ba3\\u4f20\\u4fc3\\u9500\\u65b9\\u5f0f\\u3001\\u5353\\u8d8a\\u7684\\u4ea7\\u54c1\\u8d28\\u91cf\\u4fdd\\u969c\\u3001\\u5408\\u7406\\u7684\\u4ef7\\u683c\\u4f18\\u60e0\\u7a7a\\u95f4\\uff0c\",\"items\":[{\"GoodsId\":\"605512131678\",\"Title\":\"\\u5f62\\u8c61\\u7f8e\\u7ef4\\u751f\\u7d20E\\u4e73\\u8865\\u6c34\\u4fdd\\u6e7f\\u6ecb\\u6da6\\u8eab\\u4f53\\u4e73\\u7d20\\u989c\\u9762\\u971c\\u4e73\\u6db2\\u971c\",\"ShortTitle\":\"\\u3010\\u62cd\\u4e09\\u4ef6\\u3011\\u7ef4\\u751f\\u7d20E\\u4e73\\u8865\\u6c34\\u8eab\\u4f53\\u4e73\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/804388381\\/O1CN013D2XN32BmXzYDCGCZ_!!804388381.jpg\",\"CouponMoney\":\"50\",\"Price\":\"79.90\",\"EndPrice\":\"29.90\",\"MonthSale\":\"384269\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":9.75,\"CommissionPlus\":0.48,\"MaxCommission\":9.87,\"IsCollect\":false},{\"GoodsId\":\"602602737781\",\"Title\":\"\\u301021\\u7247\\u301121\\u5929\\u8212\\u6da6\\u665a\\u5b89\\u7cbe\\u534e\\u6db2\\u8865\\u6c34\\u4fdd\\u6e7f\\u591c\\u95f4\\u63d0\\u4eae\\u80a4\\u8272\\u6536\\u7f29\\u6bdb\\u5b54\",\"ShortTitle\":\"\\u301021\\u7247\\u301121\\u5929\\u8212\\u6da6\\u665a\\u5b89\\u7cbe\\u534e\\u6db2\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/804388381\\/O1CN01UZvicN2BmXzU12w3n_!!804388381.jpg\",\"CouponMoney\":\"60\",\"Price\":\"99.00\",\"EndPrice\":\"39.00\",\"MonthSale\":\"521847\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":12.71,\"CommissionPlus\":0.62,\"MaxCommission\":12.87,\"IsCollect\":false},{\"GoodsId\":\"586537874083\",\"Title\":\"2\\u76d2|\\u6d77\\u85fb\\u7eff\\u773c\\u819c\\u8d3460\\u7247\\u7ec6\\u7eb9\\u6539\\u5584\\u9ed1\\u773c\\u5708\\u773c\\u888b\\u7d27\\u81f4\\u8865\\u6c34\\u4fdd\\u6e7f\\u6de1\\u5316\\u7537\\u5973\\u53bb\",\"ShortTitle\":\"\\u3010\\u62cd\\u4e00\\u53d1\\u4e8c\\u3011\\u6df1\\u6d77\\u85fb\\u773c\\u819c120\\u7247\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i1\\/2795017955\\/O1CN01GlqXXk28dRGVW4j9j_!!2795017955.jpg\",\"CouponMoney\":\"30\",\"Price\":\"59.90\",\"EndPrice\":\"29.90\",\"MonthSale\":\"216357\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":17.06,\"CommissionPlus\":0.84,\"MaxCommission\":17.27,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop69939369.taobao.com\",\"ShopName\":\"\\u5f62\\u8c61\\u7f8e\\u65d7\\u8230\\u5e97\",\"Total\":3,\"MinPrice\":\"29.90\",\"AvgCommission\":\"49.08%\"},{\"id\":\"501\",\"tb_brand_name\":\"\\u4e09\\u91d1\",\"fq_brand_name\":\"\\u4e09\\u91d1\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/FvOScRMCYjv61GDqA7xBsPJJFHQs\",\"brandcat\":\"3\",\"introduce\":\"\\u6842\\u6797\\u4e09\\u91d1\\u836f\\u4e1a\\u80a1\\u4efd\\u6709\\u9650\\u516c\\u53f8\\u662f\\u4e09\\u91d1\\u96c6\\u56e2\\u6709\\u6838\\u5fc3\\u4f01\\u4e1a,\\u4e3b\\u8425\\u4e2d\\u6210\\u836f\\u3001\\u5929\\u7136\\u836f\\u7269\\u7684\\u7814\\u53d1\\u4e0e\\u751f\\u4ea7,\\u662f\\u56fd\\u5185\\u6700\\u65e9\\u751f\\u4ea7\\u73b0\\u4ee3\\u4e2d\\u836f\\u5236\\u5242\\u7684\\u5382\\u4e4b\\u4e00\\u3002\",\"items\":[{\"GoodsId\":\"599897748271\",\"Title\":\"\\u4e09\\u91d1\\u5927\\u5065\\u5eb7\\u533b\\u7f8e\\u836f\\u9762\\u819c\\u6fc0\\u5149\\u672f\\u540e\\u4fee\\u590d\\u6d88\\u708e\\u68b0\\u5b57\\u53f7\\u654f\\u611f\\u808c\\u65e0\\u83cc\\u51b7\\u6577\\u8d34\",\"ShortTitle\":\"\\u3010\\u62cd2\\u4ef6\\u3011\\u4e09\\u91d1\\u68b0\\u5b57\\u53f7\\u533b\\u7528\\u533b\\u7f8e\\u9762\\u819c\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i3\\/1077821635\\/O1CN01JaaEuX1Nws8K9xGt2_!!1077821635.jpg\",\"CouponMoney\":\"200\",\"Price\":\"256.00\",\"EndPrice\":\"39.00\",\"MonthSale\":\"17066\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":9.54,\"CommissionPlus\":0.47,\"MaxCommission\":9.65,\"IsCollect\":false},{\"GoodsId\":\"601001904119\",\"Title\":\"\\u4e09\\u91d1\\u533b\\u7528\\u533b\\u7f8e\\u836f\\u9762\\u819c\\u6fc0\\u5149\\u672f\\u540e\\u4fee\\u590d\\u6d88\\u708e\\u68b0\\u5b57\\u53f7\\u654f\\u611f\\u808c\\u795b\\u75d8\\u65e0\\u83cc\\u51b7\\u6577\\u8d34\",\"ShortTitle\":\"\\u3010\\u62cd2\\u4ef6\\u3011\\u4e09\\u91d1\\u68b0\\u5b57\\u53f7\\u533b\\u7528\\u533b\\u7f8e\\u9762\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i3\\/2666040746\\/O1CN01n47Q6d1HNi1lUAnCm_!!2666040746.jpg\",\"CouponMoney\":\"200\",\"Price\":\"256.00\",\"EndPrice\":\"49.00\",\"MonthSale\":\"37179\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":11.98,\"CommissionPlus\":0.59,\"MaxCommission\":12.13,\"IsCollect\":false},{\"GoodsId\":\"574616649284\",\"Title\":\"\\u4e09\\u91d1\\u897f\\u74dc\\u971c\\u5c0f\\u82cf\\u6253\\u7259\\u818f\\u53bb\\u9ec4\\u53bb\\u53e3\\u81ed\\u53bb\\u6e0d\\u7259\\u57a2\\u53e3\\u6c14\\u6e05\\u65b0\\u4eae\\u767d\\u7259\\u818f\",\"ShortTitle\":\"\\u4e09\\u91d1 \\u5c0f\\u82cf\\u6253\\u6e05\\u65b0\\u4eae\\u767d\\u7259\\u818f3\\u652f\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/2073364739\\/O1CN01tWOOSw1ksVVF9IKka_!!2073364739.png\",\"CouponMoney\":\"10\",\"Price\":\"19.99\",\"EndPrice\":\"9.99\",\"MonthSale\":\"26988\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":3.26,\"CommissionPlus\":0.16,\"MaxCommission\":3.3,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop184123744.taobao.com\",\"ShopName\":\"\\u4e45\\u829d\\u533b\\u7597\\u5668\\u68b0\\u4e13\\u8425\\u5e97\",\"Total\":3,\"MinPrice\":\"9.99\",\"AvgCommission\":\"31.02%\"},{\"id\":\"1\",\"tb_brand_name\":\"Three Squirrels\\/\\u4e09\\u53ea\\u677e\\u9f20\",\"fq_brand_name\":\"\\u4e09\\u53ea\\u677e\\u9f20\",\"brand_logo\":\"http:\\/\\/img02.taobaocdn.com:80\\/tfscom\\/TB1jsD.DxjaK1RjSZFAXXbdLFXa\",\"brandcat\":\"3\",\"introduce\":\"\\u4e09\\u53ea\\u677e\\u9f20\\uff0c\\u4e92\\u8054\\u7f51\\u575a\\u679c\\u9500\\u91cf\\u51a0\\u519b\\u54c1\\u724c\\uff0c\\u81f4\\u529b\\u4e8e\\u751f\\u4ea7\\u5929\\u7136\\u65b0\\u9c9c\\u3001\\u975e\\u8fc7\\u5ea6\\u52a0\\u5de5\\u7684\\u5065\\u5eb7\\u98df\\u54c1\\uff0c\\u8a93\\u5c06\\u5356\\u840c\\u670d\\u52a1\\u4e0e\\u6781\\u81f4\\u7528\\u6237\\u4f53\\u9a8c\\u8fdb\\u884c\\u5230\\u5e95\\uff0c\\u6570\\u767e\\u4e07\\u6d88\\u8d39\\u8005\\u7684\\u4e0d\\u4e8c\\u9009\\u62e9\\uff0c\\u503c\\u5f97\\u4fe1\\u8d56\\uff01\",\"items\":[{\"GoodsId\":\"558587300390\",\"Title\":\"\\u3010\\u4e09\\u53ea\\u677e\\u9f20_\\u96f6\\u98df\\u5927\\u793c\\u5305\\u3011\\u7f51\\u7ea2\\u7206\\u6b3e\\u575a\\u679c\\u4f11\\u95f2\\u5c0f\\u5403\\u997c\\u5e72\\u6563\\u88c5\\u98df\\u54c1\\u4e00\\u7bb1\",\"ShortTitle\":\"\\u3010\\u4e09\\u53ea\\u677e\\u9f20\\u3011\\u96f6\\u98df\\u5927\\u793c\\u5305\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.haodanku.com\\/oimg_558587300390_1569895069.jpg\",\"CouponMoney\":\"5\",\"Price\":\"49.90\",\"EndPrice\":\"29.90\",\"MonthSale\":\"694976\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":3.66,\"CommissionPlus\":0.18,\"MaxCommission\":3.7,\"IsCollect\":false},{\"GoodsId\":\"601031462377\",\"Title\":\"\\u65b0\\u54c1\\u3010\\u4e09\\u53ea\\u677e\\u9f20_\\u5ca9\\u70e7\\u4e73\\u916a\\u5410\\u53f8520g\\/\\u6574\\u7bb1\\u3011\\u98df\\u54c1\\u65e9\\u9910\\u9762\\u5305\\u5c0f\\u86cb\\u7cd5\\u96f6\\u98df\",\"ShortTitle\":\"\\u4e09\\u53ea\\u677e\\u9f20_\\u5ca9\\u70e7\\u4e73\\u916a\\u5410\\u53f8520g\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i1\\/880734502\\/O1CN01iZgufC1j7xdzhgvAZ_!!880734502.jpg\",\"CouponMoney\":\"3\",\"Price\":\"59.80\",\"EndPrice\":\"36.80\",\"MonthSale\":\"209571\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":4.5,\"CommissionPlus\":0.22,\"MaxCommission\":4.55,\"IsCollect\":false},{\"GoodsId\":\"567448023753\",\"Title\":\"\\u3010\\u4e09\\u53ea\\u677e\\u9f20_\\u96ea\\u8299\\u857e\\u86cb\\u7cd51000g\\/\\u6574\\u7bb1\\u3011\\u8425\\u517b\\u65e9\\u9910\\u7f51\\u7ea2\\u53e3\\u888b\\u5939\\u5fc3\\u5c0f\\u9762\\u5305\",\"ShortTitle\":\"\\u4e09\\u53ea\\u677e\\u9f20\\u96ea\\u9eb8\\u86cb\\u7cd5\\u6574\\u7bb11000g\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i4\\/880734502\\/O1CN01KQviUH1j7xaijA3jK_!!880734502.jpg\",\"CouponMoney\":\"3\",\"Price\":\"29.90\",\"EndPrice\":\"21.90\",\"MonthSale\":\"68579\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":2.68,\"CommissionPlus\":0.13,\"MaxCommission\":2.71,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop71720200.taobao.com\",\"ShopName\":\"\\u4e09\\u53ea\\u677e\\u9f20\\u65d7\\u8230\\u5e97\",\"Total\":3,\"MinPrice\":\"21.90\",\"AvgCommission\":\"15.01%\"},{\"id\":\"3\",\"tb_brand_name\":\"\\u5357\\u6781\\u4eba\",\"fq_brand_name\":\"\\u5357\\u6781\\u4eba\",\"brand_logo\":\"http:\\/\\/img04.taobaocdn.com:80\\/tfscom\\/TB1yXj2DpzqK1RjSZFCXXbbxVXa\",\"brandcat\":\"6\",\"introduce\":\"\\u5357\\u6781\\u4eba\\uff0c\\u6210\\u7acb\\u4e8e1998\\u5e74\\uff0c\\u662f\\u4e2d\\u56fd\\u6700\\u65e9\\u6210\\u7acb\\u7684\\u5185\\u8863\\u4f01\\u4e1a\\u4e4b\\u4e00,\\u9996\\u521b\\u4fdd\\u6696\\u5185\\u8863\\u4ea7\\u54c1\\u5f00\\u521b\\u4e86\\u4e2d\\u56fd\\u5185\\u8863\\u884c\\u4e1a\\u53d1\\u5c55\\u7684\\u65b0\\u9053\\u8def\\uff0c\\u5e76\\u9010\\u6e10\\u53d1\\u5c55\\u6210\\u4e3a\\u5bb6\\u55bb\\u6237\\u6653\\u7684\\u4fdd\\u6696\\u5185\\u8863\\u54c1\\u724c\\uff1b\\u4ece2008\\u5e74\\u5f00\\u59cb\\uff0c\\u5f00\\u542f\\u54c1\\u724c\\u6388\\u6743\\u5546\\u4e1a\\u6a21\\u5f0f\\uff1b2015\\u5e74\\u5b8c\\u6210\\u501f\\u58f3\\u4e0a\\u5e02\\uff0c\\u6210\\u4e3aA\\u80a1\\u4e0a\\u5e02\\u516c\\u53f8\\u3002\\n\\u7ecf\\u8fc720\\u5e74\\u7684\\u53d1\\u5c55\\uff0c\\u5357\\u6781\\u4eba\\u76ee\\u524d\\u5df2\\u7ecf\\u6210\\u4e3a\\u6a2a\\u8de8\\u5185\\u8863\\u3001\\u5bb6\\u7eba\\u3001\\u7537\\u5973\\u88c5\\u3001\\u6bcd\\u5a74\\u7528\\u54c1\\u7b49\\u8d85\\u591a\\u54c1\\u7c7b\\uff0c\\u56ca\\u62ec\\u4e86\\u6d77\\u91cf\\u6781\\u5177\\u6027\\u4ef7\\u6bd4\\u7684\\u65e5\\u5e38\\u751f\\u6d3b\\u6240\\u9700\\u4ea7\\u54c1\\uff0c\\u5e76\\u66f4\\u7b26\\u5408\\u56fd\\u4eba\\u6d88\\u8d39\\u4e60\\u60ef\\u7684\\u5168\\u6c11\\u5bb6\\u5ead\\u5927\\u54c1\\u724c\\u3002\",\"items\":[{\"GoodsId\":\"600783847202\",\"Title\":\"\\u5357\\u6781\\u4eba\\u7eb8\\u5c3f\\u88e4\\u5a74\\u513f\\u8d85\\u8584\\u900f\\u6c14\\u62c9\\u62c9\\u88e4S\\/M\\/L\\/XL\\u5b9d\\u5b9d\\u8bd5\\u7528\\u88c5\\u5c3f\\u4e0d\\u6e7f\\u5e72\\u723d\",\"ShortTitle\":\"\\u3010\\u5357\\u6781\\u4eba\\u3011\\u8d85\\u8584\\u900f\\u6c14\\u7eb8\\u5c3f\\u88e420\\u7247\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i4\\/2837927451\\/O1CN01ZsVIHb24ubeGVZwoY_!!2837927451.jpg\",\"CouponMoney\":\"2\",\"Price\":\"10.99\",\"EndPrice\":\"8.99\",\"MonthSale\":\"153221\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":1.47,\"CommissionPlus\":0.07,\"MaxCommission\":1.49,\"IsCollect\":false},{\"GoodsId\":\"602896299999\",\"Title\":\"\\u5357\\u6781\\u4eba\\u6253\\u5e95\\u88e4\\u5973\\u88e4\\u5916\\u7a7f\\u52a0\\u7ed2\\u52a0\\u539a\\u5c0f\\u811a\\u79cb\\u51ac2019\\u65b0\\u6b3e\\u9ad8\\u8170\\u94c5\\u7b14\\u4fdd\\u6696\\u9ed1\\u8272\",\"ShortTitle\":\"\\u5357\\u6781\\u4eba\\u3010\\u52a0\\u7ed2\\u52a0\\u539a\\u3011\\u9ad8\\u8170\\u5c0f\\u811a\\u88e4\\u79cb\\u51ac\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/2144108326\\/O1CN01jHYzGo2BNMCj28ssI_!!2144108326.jpg\",\"CouponMoney\":\"15\",\"Price\":\"34.90\",\"EndPrice\":\"19.90\",\"MonthSale\":\"123937\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":4.87,\"CommissionPlus\":0.24,\"MaxCommission\":4.93,\"IsCollect\":false},{\"GoodsId\":\"601699838453\",\"Title\":\"\\u5357\\u6781\\u4eba\\u88ab\\u5b50\\u51ac\\u88ab\\u82af\\u51ac\\u5929\\u52a0\\u539a\\u4fdd\\u6696\\u5bbf\\u820d\\u5355\\u4eba\\u5b66\\u751f\\u53cc\\u4eba\\u7a7a\\u8c03\\u6625\\u79cb\\u51ac\\u5b63\\u68c9\\u88ab\",\"ShortTitle\":\"\\u3010\\u5168\\u5c3a\\u5bf8\\u4e00\\u4e2a\\u4ef7\\u3011\\u5357\\u6781\\u4eba\\u88ab\\u5b50\\u51ac\\u88ab\\u82af\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i3\\/1674422407\\/O1CN01AQcOCv1TeRsy10ktv_!!1674422407.jpg\",\"CouponMoney\":\"20\",\"Price\":\"79.00\",\"EndPrice\":\"59.00\",\"MonthSale\":\"301862\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":9.62,\"CommissionPlus\":0.47,\"MaxCommission\":9.74,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop258418322.taobao.com\",\"ShopName\":\"\\u5357\\u6781\\u4eba\\u660e\\u82af\\u4e13\\u5356\\u5e97\",\"Total\":3,\"MinPrice\":\"8.99\",\"AvgCommission\":\"22.27%\"},{\"id\":\"666\",\"tb_brand_name\":\"\\u82ad\\u7c73\",\"fq_brand_name\":\"\\u82ad\\u7c73\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/Ft0kxwkqxs2m-gYEUSFJfQA0zDCp\",\"brandcat\":\"3\",\"introduce\":\"\\u82ad\\u7c73\\u98df\\u54c1\\u521b\\u7acb\\u4e8e2014\\u5e74\\uff0c\\u5f00\\u521b\\u4e86\\u4e2d\\u56fd\\u725b\\u8f67\\u7cd6\\u7cd5\\u70b9\\u54c1\\u7c7b\\uff0c\\u72ec\\u521b\\u7684\\u8f6f\\u5976\\u725b\\u8f67\\u997c\\u751c\\u54b8\\u76f8\\u5b9c\\uff0c\\u56fd\\u5185\\u7b2c\\u4e00\\u4e2a\\u5927\\u578b\\u98df\\u54c1\\u7814\\u53d1\\u751f\\u4ea7\\u5236\\u9020\\u57fa\\u5730\\u300210\\u4e07\\u5bb6\\u96f6\\u552e\\u7ec8\\u7aef\\u5728\\u552e\\uff0c5\\u5343\\u4e07\\u4eba\\u90fd\\u5728\\u5403\\u82ad\\u7c73\\u7cd5\\u70b9\\u3002\",\"items\":[{\"GoodsId\":\"566103431545\",\"Title\":\"\\u82ad\\u7c73\\u8f6f\\u5976\\u725b\\u624e\\u997c\\u5e721\\u76d2 \\u53f0\\u6e7e\\u98ce\\u5473\\u624b\\u5de5\\u725b\\u8f67\\u7cd6\\u82cf\\u6253\\u5939\\u5fc3\\u997c\\u5e72 \\u4f11\\u95f2\\u96f6\\u98df\",\"ShortTitle\":\"\\u3010\\u674e\\u4f73\\u742a\\u529b\\u63a8\\uff0c\\u62cd\\u4e94\\u4efd\\u3011\\u82cf\\u6253\\u5939\\u5fc3\\u997c\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i4\\/287761419\\/O1CN01bR3nWl1MLwaEBRE83_!!287761419.jpg\",\"CouponMoney\":\"15\",\"Price\":\"64.00\",\"EndPrice\":\"24.80\",\"MonthSale\":\"78388\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":6.06,\"CommissionPlus\":0.3,\"MaxCommission\":6.14,\"IsCollect\":false},{\"GoodsId\":\"595854768784\",\"Title\":\"\\u82ad\\u7c73\\u725b\\u8f67\\u7cd6\\u997c\\u5e72\\u6c34\\u679c\\u997c\\u5e72\\u86cb\\u5377\\u7b49 \\u96f6\\u98df\\u81ea\\u914d\\u5927\\u793c\\u5305 \\u7f51\\u7ea2\\u4f11\\u95f2\\u96f6\\u98df\\u7cd5\\u70b9\",\"ShortTitle\":\"\\u62cd5\\u4ef6\\u82ad\\u7c73\\u96f6\\u98df\\u81ea\\u914d\\u5927\\u793c\\u53055\\u5927\\u76d2\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i3\\/3012913363\\/O1CN01TgOf4x1aiIWb9bObB_!!3012913363.jpg\",\"CouponMoney\":\"25\",\"Price\":\"49.80\",\"EndPrice\":\"24.80\",\"MonthSale\":\"257164\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":6.06,\"CommissionPlus\":0.3,\"MaxCommission\":6.14,\"IsCollect\":false},{\"GoodsId\":\"559260116859\",\"Title\":\"\\u82ad\\u7c73\\u725b\\u8f67\\u96ea\\u82b1\\u9165 \\u725b\\u5976\\u8513\\u8d8a\\u8393\\u725b\\u624e\\u7cd6\\u5976\\u8299\\u997c\\u5e72\\u6c99\\u742a\\u739b\\u4f20\\u7edf\\u7cd5\\u70b9\\u96f6\\u98df\",\"ShortTitle\":\"\\u62cd5\\u4ef6\\uff01\\u82ad\\u7c73\\u725b\\u8f67\\u96ea\\u82b1\\u9165\\u7cd5175g\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i1\\/2944089159\\/O1CN01hAP5bA2HWs6rkIl3m_!!2944089159.jpg\",\"CouponMoney\":\"10\",\"Price\":\"19.50\",\"EndPrice\":\"9.50\",\"MonthSale\":\"22801\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":2.32,\"CommissionPlus\":0.11,\"MaxCommission\":2.35,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop329702428.taobao.com\",\"ShopName\":\"\\u82ad\\u7c73\\u98df\\u54c1\\u65d7\\u8230\\u5e97\",\"Total\":3,\"MinPrice\":\"9.50\",\"AvgCommission\":\"30%\"},{\"id\":\"471\",\"tb_brand_name\":\"Coati\\/\\u5c0f\\u6d63\\u718a\",\"fq_brand_name\":\"\\u5c0f\\u6d63\\u718a\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/FnFdFQl5BYHiUVIDTBhRINSov-gi\",\"brandcat\":\"1\",\"introduce\":\"\\u201c\\u5c0f\\u6d63\\u718a\\u201d\\u662f\\u6df1\\u53d7\\u5c0f\\u670b\\u53cb\\u548c\\u7238\\u7238\\u5988\\u5988\\u4eec\\u6b22\\u8fce\\u7684\\u5a74\\u7ae5\\u62a4\\u7406\\u54c1\\u724c\\u3002\\u5c0f\\u670b\\u53cb\\u4eec\\u559c\\u7231\\u201c\\u5c0f\\u6d63\\u718a\\u201d\\u5065\\u5eb7\\u3001\\u6d3b\\u6cfc\\u3001\\u7075\\u52a8\\u3001\\u5145\\u6ee1\\u6d3b\\u529b\\u7684\\u5f62\\u8c61\\uff0c\\u7238\\u7238\\u5988\\u5988\\u4eec\\u5219\\u8ba4\\u53ef\\u201c\\u5c0f\\u6d63\\u718a\\u201d\\u7eaf\\u51c0\\u3001\\u5b89\\u5168\\u3001\\u4f18\\u5f02\\u7684\\u4ea7\\u54c1\\u54c1\\u8d28\\u3002\",\"items\":[{\"GoodsId\":\"576685693692\",\"Title\":\"\\u5c0f\\u6d63\\u718a\\u513f\\u7ae5\\u9762\\u971c\\u5b9d\\u5b9d\\u6ecb\\u6da6\\u64e6\\u8138\\u4fdd\\u6e7f\\u971c\\u62a4\\u80a4\\u9732\\u5e7c\\u8865\\u6c34\\u79cb\\u51ac\\u4e73\\u5a74\\u513f\\u9762\\u971c\",\"ShortTitle\":\"\\u62cd2\\u4ef619.9 \\u5c0f\\u6d63\\u718a\\u9762\\u971c+\\u5507\\u818f\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i4\\/836386187\\/O1CN011vZgvzB3GQlkgoK_!!836386187.jpg\",\"CouponMoney\":\"20\",\"Price\":\"38.90\",\"EndPrice\":\"18.90\",\"MonthSale\":\"422350\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":4.62,\"CommissionPlus\":0.23,\"MaxCommission\":4.68,\"IsCollect\":false},{\"GoodsId\":\"578952137739\",\"Title\":\"\\u5c0f\\u6d63\\u718a\\u513f\\u7ae5\\u7259\\u818f3-6-12\\u5c81\\u65e0\\u6c1f\\u6c34\\u679c\\u5473\\u7259\\u818f\\u5b9d\\u5b9d\\u6362\\u7259\\u671f\\u53bb\\u7259\\u6e0d\\u7259\\u5237\\u5957\\u88c5\",\"ShortTitle\":\"\\u3010\\u5c0f\\u6d63\\u718a\\u3011\\u513f\\u7ae5\\u7259\\u818f4\\u652f+\\u7259\\u52371\\u652f\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i3\\/836386187\\/O1CN011vZgvZWuYzgNW8w_!!836386187.jpg\",\"CouponMoney\":\"10\",\"Price\":\"34.90\",\"EndPrice\":\"24.90\",\"MonthSale\":\"8916\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":6.09,\"CommissionPlus\":0.3,\"MaxCommission\":6.16,\"IsCollect\":false},{\"GoodsId\":\"604313718942\",\"Title\":\"\\u5c0f\\u6d63\\u718a\\u6b63\\u54c1\\u5a74\\u5e7c\\u513f\\u7ae5\\u5507\\u818f\\u5b9d\\u5b9d\\u5b66\\u751f\\u62a4\\u5507\\u818f\\u5973\\u5b69\\u5c0f\\u5b69\\u6ecb\\u6da6\\u4fdd\\u6e7f\\u7537\\u5973\\u53ef\\u7231\",\"ShortTitle\":\"\\u5c0f\\u6d63\\u718a\\u5507\\u818f\\u62a4\\u624b\\u971c\\u5957\\u88c5\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i3\\/836386187\\/O1CN01ESFSij1vZh1Ok57xz_!!836386187.jpg\",\"CouponMoney\":\"15\",\"Price\":\"29.90\",\"EndPrice\":\"9.90\",\"MonthSale\":\"1434\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":2.42,\"CommissionPlus\":0.12,\"MaxCommission\":2.45,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop70618522.taobao.com\",\"ShopName\":\"\\u5c0f\\u6d63\\u718a\\u65d7\\u8230\\u5e97\",\"Total\":3,\"MinPrice\":\"9.90\",\"AvgCommission\":\"30%\"},{\"id\":\"507\",\"tb_brand_name\":\"\\u7231\\u597d\",\"fq_brand_name\":\"\\u7231\\u597d\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/Fhe9bPsOgLrIrhC0sY0DsL6fCtaO\",\"brandcat\":\"4\",\"introduce\":\"\\u7231\\u597d\\u7b14\\u4e1a\\u662f\\u4e00\\u5bb6\\u4ee5\\u4e66\\u5199\\u5de5\\u5177\\u4e3a\\u6838\\u5fc3\\u7684\\u6587\\u5177\\u751f\\u4ea7\\u4f01\\u4e1a\\uff0c\\u5e76\\u62e5\\u6709\\u5b8c\\u6574\\u7684\\u6587\\u5177\\u54c1\\u7c7b\\u7814\\u53d1\\u751f\\u4ea7\\u80fd\\u529b\\u548c\\u9500\\u552e\\u7f51\\u7edc\\u670d\\u52a1\\u80fd\\u529b\\uff0c\\u662f\\u76ee\\u524d\\u56fd\\u5185\\u89c4\\u6a21\\u6700\\u5927\\u3001\\u6280\\u672f\\u6700\\u5148\\u8fdb\\u7684\\u5927\\u578b\\u6587\\u5177\\u751f\\u4ea7\\u4f01\\u4e1a\\u4e4b\\u4e00\\u3002\\u516c\\u53f8\\u81f4\\u529b\\u4e8e\\u8d70\\u73e0\\u7b14\\u3001\\u4e2d\\u6027\\u7b14\\u3001\\u8367\\u5149\\u7b14\\u3001\\u5706\\u73e0\\u7b14\\u3001\\u6d3b\\u52a8\\u94c5\\u7b14\\u3001\\u6c34\\u5f69\\u7b14\\u3001\\u6c34\\u7b14\\u7b49\\u516d\\u5927\\u7b14\\u7c7b\\u7684\\u751f\\u4ea7\\u548c\\u5f00\\u53d1\\uff0c\\u76ee\\u524d\\u4ea7\\u54c1\\u5df2\\u8fbe100\\u591a\\u4e2a\\u89c4\\u683c\\u54c1\\u79cd\\u3002\",\"items\":[{\"GoodsId\":\"551566421869\",\"Title\":\"\\u7231\\u597d\\u94a2\\u7b14\\u58a8\\u6c34\\u7ea2\\u84dd\\u9ed1\\u8272\\u58a8\\u56ca\\u5c0f\\u5b66\\u751f \\u4e09\\u5e74\\u7ea7\\u4e13\\u7528\\u7537\\u5973\\u5f69\\u58a8\\u5957\\u88c5\\u513f\\u7ae5\\u53ef\\u66ff\\u6362\\u58a8\\u80c6\\u53ef\\u64e6\\u975e\\u78b3\\u7d20\\u94a2\\u7b14\\u6c34ink\\u76f4\\u6db2\\u5f0f\\u4e0a\\u58a8\\u5668\",\"ShortTitle\":\"\\u7231\\u597d\\u53ef\\u66ff\\u6362\\u94a2\\u7b1410\\u652f+\\u58a8\\u56ca10\\u652f\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/54388138\\/O1CN01RtRkbc29zFjsF3gK8_!!54388138.jpg\",\"CouponMoney\":\"5\",\"Price\":\"9.90\",\"EndPrice\":\"5.90\",\"MonthSale\":\"10725\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":1.44,\"CommissionPlus\":0.07,\"MaxCommission\":1.46,\"IsCollect\":false},{\"GoodsId\":\"600368760155\",\"Title\":\"\\u7231\\u597d150m\\u4fee\\u6b63\\u5e26\\u5b9e\\u60e0\\u88c5\\u6d82\\u6539\\u5e26\\u5b66\\u751f\\u6539\\u6b63\\u5e26\\u53ef\\u7231\\u97e9\\u56fd\\u521b\\u610f\\u591a\\u529f\\u80fd\\u5c11\\u5973\\u5c0f\\u6e05\\u65b0\\u5927\\u5bb9\\u91cf\\u6539\\u5b57\\u5e26\\u4e2d\\u5c0f\\u5b66\\u751f\\u6587\\u5177\\u6279\\u53d1\\u514d\\u8fd0\\u8d39\",\"ShortTitle\":\" \\u7231\\u597d\\u4fee\\u6b63\\u5e265\\u53ea\\u88c5\\u90012\\u53ea\\u4e2d\\u6027\\u7b14\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/173630501\\/O1CN01rZDjmZ1FZUzju3Dc0_!!173630501.jpg\",\"CouponMoney\":\"2\",\"Price\":\"9.80\",\"EndPrice\":\"7.80\",\"MonthSale\":\"14939\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":1.27,\"CommissionPlus\":0.06,\"MaxCommission\":1.29,\"IsCollect\":false},{\"GoodsId\":\"585828563555\",\"Title\":\"\\u7231\\u597d\\u77eb\\u59ff\\u4e2d\\u6027\\u7b14\\u5927\\u5bb9\\u91cf\\u77eb\\u6b63\\u7b140.5mm\\u5b66\\u751f\\u7528\\u8003\\u8bd5\\u7b7e\\u5b57\\u7b1447920\\u78b3\\u7d20\\u7b14\\u9ed1\\u8272\\u6c34\\u7b14\\u5168\\u9488\\u7ba1\\u7ea2\\u84dd\\u8272\\u4e00\\u6b21\\u6027\\u4e09\\u89d2\\u5f62\\u7b14\\u8d22\\u52a1\\u6746\",\"ShortTitle\":\"\\u5b66\\u751f\\u7ec3\\u5b57\\u77eb\\u59ff\\u94a2\\u7b14\\u53ef\\u6362\\u58a8\\u56ca\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/14107072\\/O1CN01Sf6dej2271XjSGJCG_!!14107072.jpg\",\"CouponMoney\":\"3\",\"Price\":\"6.90\",\"EndPrice\":\"3.90\",\"MonthSale\":\"4797\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":0.95,\"CommissionPlus\":0.05,\"MaxCommission\":0.97,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop338552509.taobao.com\",\"ShopName\":\"\\u7231\\u597d\\u6587\\u5177\\u65d7\\u8230\\u5e97\",\"Total\":3,\"MinPrice\":\"3.90\",\"AvgCommission\":\"25.57%\"},{\"id\":\"697\",\"tb_brand_name\":\"\\u718a\\u672c\\u5bb6\",\"fq_brand_name\":\"\\u718a\\u672c\\u5bb6\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/Fk1IyBGRQzWh9CSxw5Ztq-o3DiHF\",\"brandcat\":\"3\",\"introduce\":\"\\u718a\\u672c\\u5bb6\\u662f\\u6cc9\\u5dde\\u60e0\\u5bb6\\u98df\\u54c1\\u6709\\u9650\\u516c\\u53f8\\u65d7\\u4e0b\\u7684\\u7535\\u5546\\u54c1\\u724c\\u7cd5\\u70b9\\u3002\\u4e13\\u6ce8\\u4e8e\\u9ad8\\u54c1\\u8d28\\u70d8\\u7119\\uff0c\\u81f4\\u529b\\u6210\\u4e3a\\u4e2d\\u56fd\\u7cd5\\u70b9\\u884c\\u4e1a\\u7684\\u9886\\u8dd1\\u8005\\u3002\",\"items\":[{\"GoodsId\":\"599147276889\",\"Title\":\"\\u718a\\u672c\\u5bb6\\u7d2b\\u7c73\\u9762\\u5305\\u571f\\u53f8\\u5976\\u916a\\u624b\\u6495\\u7f51\\u7ea2\\u65e9\\u9910\\u5207\\u7247\\u7cd5\\u70b9\\u96f6\\u98df\\u54c1500g\\u5410\\u53f8\\u6574\\u7bb1\",\"ShortTitle\":\"\\u718a\\u672c\\u5bb6\\u7f51\\u7ea2\\u5939\\u5fc3\\u7d2b\\u7c73\\u9762\\u53051000g\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i4\\/3866101533\\/O1CN01vag1iA1NC9j7lBBAm_!!3866101533.jpg\",\"CouponMoney\":\"5\",\"Price\":\"24.99\",\"EndPrice\":\"14.99\",\"MonthSale\":\"128452\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":3.67,\"CommissionPlus\":0.18,\"MaxCommission\":3.71,\"IsCollect\":false},{\"GoodsId\":\"566352261884\",\"Title\":\"\\u718a\\u672c\\u5bb6 \\u5410\\u53f8\\u9762\\u53051000g\\u6574\\u7bb1\\u5939\\u5fc3\\u53e3\\u888b\\u4e09\\u660e\\u6cbb\\u5207\\u7247\\u7f51\\u7ea2\\u65e9\\u9910\\u6d82\\u62b9\\u5c0f\\u571f\\u53f8\",\"ShortTitle\":\"\\u7b2c\\u4e8c\\u4ef6\\u534a\\u4ef7\\u3001\\u7f51\\u7ea2\\u5410\\u53f8\\u5939\\u5fc3420g\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i1\\/3866101533\\/O1CN012M0ic11NC9fQWs3nz_!!3866101533.jpg\",\"CouponMoney\":\"5\",\"Price\":\"14.99\",\"EndPrice\":\"8.99\",\"MonthSale\":\"52362\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":2.2,\"CommissionPlus\":0.11,\"MaxCommission\":2.23,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop435486968.taobao.com\",\"ShopName\":\"\\u718a\\u672c\\u5bb6\\u65d7\\u8230\\u5e97\",\"Total\":2,\"MinPrice\":\"8.99\",\"AvgCommission\":\"30.03%\"},{\"id\":\"440\",\"tb_brand_name\":\"\\u7a3b\\u82b1\\u9999\",\"fq_brand_name\":\"\\u7a3b\\u82b1\\u9999\",\"brand_logo\":\"http:\\/\\/img.haodanku.com\\/FruVqm32PZ3yPiYL6zY_BF8vLnkm\",\"brandcat\":\"3\",\"introduce\":\"\\u7a3b\\u82b1\\u9999\\u662f\\u4ee5\\u767d\\u9152\\u4ea7\\u4e1a\\u4e3a\\u9f99\\u5934\\uff0c\\u96c6\\u7eff\\u8272\\u98df\\u54c1\\u3001\\u996e\\u6599\\u3001\\u5305\\u88c5\\u5236\\u54c1\\u3001\\u751f\\u7269\\u5316\\u5de5\\u3001\\u73b0\\u4ee3\\u7269\\u6d41\\u3001\\u80fd\\u6e90\\u5f00\\u53d1\\u3001\\u751f\\u6001\\u519c\\u4e1a\\u3001\\u9972\\u6599\\u3001\\u517b\\u6b96\\u7b49\\u5faa\\u73af\\u7ecf\\u6d4e\\u4ea7\\u4e1a\\u4e3a\\u4e00\\u4f53\\u914d\\u5957\\u53d1\\u5c55\\u7684\\u5927\\u578b\\u4f01\\u4e1a\\u96c6\\u56e2\\u3002\",\"items\":[{\"GoodsId\":\"595298132639\",\"Title\":\"\\u3010\\u62cd6\\u687619.9\\u5143\\u3011\\u7a3b\\u82b1\\u9999\\u73cd\\u54c1\\u8fc7\\u6865\\u7c73\\u7ebf\\u7c89\\u4e1d\\u4e91\\u5357\\u9178\\u8fa3\\u7c89\\u65b9\\u4fbf\\u6ce1\\u97621\\u6876\\u88c5\",\"ShortTitle\":\"\\u3010\\u62cd6\\u687619.4\\u3011\\u7a3b\\u82b1\\u9999\\u8fc7\\u6865\\u7c73\\u7ebf\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/i3\\/3416832369\\/O1CN01WNIPY61TN2p2aX0m7_!!3416832369.jpg\",\"CouponMoney\":\"20\",\"Price\":\"59.40\",\"EndPrice\":\"19.90\",\"MonthSale\":\"82313\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":3.24,\"CommissionPlus\":0.16,\"MaxCommission\":3.28,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop202000334.taobao.com\",\"ShopName\":\"\\u7a3b\\u82b1\\u9999\\u98df\\u54c1\\u65d7\\u8230\\u5e97\",\"Total\":1,\"MinPrice\":\"19.90\",\"AvgCommission\":\"20%\"},{\"id\":\"2\",\"tb_brand_name\":\"BE\\uff06CHEERY\\/\\u767e\\u8349\\u5473\",\"fq_brand_name\":\"\\u767e\\u8349\\u5473\",\"brand_logo\":\"http:\\/\\/img02.taobaocdn.com:80\\/tfscom\\/TB1JCfSDwTqK1RjSZPhXXXfOFXa\",\"brandcat\":\"3\",\"introduce\":\"\\u767e\\u8349\\u5473\\uff0c\\u54c1\\u8d28\\u96f6\\u98df\\u9886\\u5bfc\\u54c1\\u724c\\u3002 \\u575a\\u6301\\u4ee5\\u6700\\u771f\\u5b9e\\u8bda\\u6073\\u7684\\u6001\\u5ea6\\uff0c\\u5c06\\u5927\\u81ea\\u7136\\u8d50\\u4e88\\u7684\\u7f8e\\u5473\\u4f20\\u9012\\u7ed9\\u6bcf\\u4e00\\u4f4d\\u70ed\\u7231\\u7f8e\\u98df\\u7684\\u987e\\u5ba2\\u3002 \\u5341\\u4e8c\\u5e74\\u4e13\\u6ce8\\uff0c\\u54c1\\u8d28\\u5353\\u8d8a\\u975e\\u51e1\\u3002\\u4eba\\u751f\\u767e\\u5473\\uff0c\\u5c3d\\u5728\\u767e\\u8349\\u5473\\u3002\",\"items\":[{\"GoodsId\":\"601059227250\",\"Title\":\"\\u65b0\\u54c1\\u3010\\u767e\\u8349\\u5473-\\u9ebb\\u8fa3\\u96f6\\u98df\\u5927\\u793c\\u5305\\u3011\\u7f51\\u7ea2\\u4f11\\u95f2\\u98df\\u54c1\\u591c\\u5bb5\\u6574\\u7bb1\\u6563\\u88c5\\u5c0f\\u5403\",\"ShortTitle\":\"\\u767e\\u8349\\u5473\\u9ebb\\u8fa3\\u96f6\\u98df\\u5927\\u793c\\u5305535g*2\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i4\\/628189716\\/O1CN01fwT4wU2Ldyjg585FW_!!628189716.jpg\",\"CouponMoney\":\"15\",\"Price\":\"89.80\",\"EndPrice\":\"39.80\",\"MonthSale\":\"75736\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":4.87,\"CommissionPlus\":0.24,\"MaxCommission\":4.93,\"IsCollect\":false},{\"GoodsId\":\"604510459231\",\"Title\":\"\\u65b0\\u54c1\\u3010\\u767e\\u8349\\u5473-\\u54b8\\u86cb\\u9ec4\\u9ea6\\u82bd\\u997c\\u5e72110gx2\\u888b\\u3011\\u9ed1\\u7cd6\\u5939\\u5fc3\\u7f51\\u7ea2\\u5c0f\\u96f6\\u98df\\u96f6\\u98df\",\"ShortTitle\":\"\\u767e\\u8349\\u5473\\u54b8\\u86cb\\u9ec4\\u9ea6\\u82bd\\u997c\\u5e722\\u888b\\u88c5\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"http:\\/\\/img.alicdn.com\\/imgextra\\/i1\\/628189716\\/O1CN01pAIXEc2LdyjjHwI3S_!!628189716.jpg\",\"CouponMoney\":\"3\",\"Price\":\"13.90\",\"EndPrice\":\"10.90\",\"MonthSale\":\"14964\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":1.34,\"CommissionPlus\":0.07,\"MaxCommission\":1.35,\"IsCollect\":false},{\"GoodsId\":\"586389264193\",\"Title\":\"\\u65b0\\u54c1\\u3010\\u767e\\u8349\\u5473-\\u53bb\\u9aa8\\u51e4\\u722a135g\\u3011\\u9178\\u8fa3\\u6ce1\\u6912\\u65e0\\u9aa8\\u9e21\\u722a\\u96f6\\u98df\\u5c0f\\u5403\\u4f11\\u95f2\\u98df\\u54c1\",\"ShortTitle\":\"\\u7b2c\\u4e8c\\u4efd9.9\\uff01\\u767e\\u8349\\u5473\\u9178\\u8fa3\\u65e0\\u9aa8\\u51e4\\u722a\",\"ShopType\":\"\\u5929\\u732b\",\"PicLogo\":\"https:\\/\\/img.alicdn.com\\/imgextra\\/i2\\/628189716\\/O1CN01SEFLr92LdyjieP8UM_!!628189716.jpg\",\"CouponMoney\":\"5\",\"Price\":\"22.90\",\"EndPrice\":\"17.90\",\"MonthSale\":\"3680\",\"Site\":\"haodanku\",\"CouponSurplus\":1,\"Commission\":2.18,\"CommissionPlus\":0.11,\"MaxCommission\":2.21,\"IsCollect\":false}],\"ShopUrl\":\"https:\\/\\/shop63612646.taobao.com\",\"ShopName\":\"\\u767e\\u8349\\u5473\\u65d7\\u8230\\u5e97\",\"Total\":3,\"MinPrice\":\"10.90\",\"AvgCommission\":\"15%\"}]},\"msg\":\"\\u64cd\\u4f5c\\u6210\\u529f\"}"
            val model = JsonUtils.parseFromJson<BrandListModel>(json)
//            Utils.printJson(json)
            /*普通请求*/
            HttpService.Builder("http://api.jiruanos.com/api/user/profile")
                .post()
                .sendPublicKey(false)
                .enqueue(object : BaseCallback<BeanJavaT<BeanJava2>>() {
                    override fun suc(value: BeanJavaT<BeanJava2>) {
                        Log.e("HttpService", "数量：$value")
                    }

                    override fun failed(e: Throwable?, isNetworkError: Boolean, parse: Boolean) {
                    }
                })
//            val url="https://www.taobao.com"
            val url = "https://dscnew.taobao.com/i5/590/780/590782412752/TB1w22QArr1gK0jSZFD8qv9yVla.desc%7Cvar%5Edesc%3Bsign%5E67d207d0fec3308c05fd655d7a8cc6ff%3Blang%5Egbk%3Bt%5E1586180681"
            HttpService.Builder(url)
                .post()
                .sendPublicKey(false)
                .enqueue(object : Callback<String>() {


                    override fun onFailure(e: Throwable, isNetworkError: Boolean) {

                    }

                    override fun onResponse(value: String?) {
                        Log.e("123213", value)
                    }
                })
        }
        tv1.setOnClickListener {
            /*下载*/
            //http://video.haodanku.com/95ec3a0a93f144790a8e777eb0c69d9d?attname=1568698684.mp4
//            https://dldir1.qq.com/weixin/android/weixin673android1360.apk
            //https://download.alicdn.com/wireless/juhuasuan4android/latest/juhuasuan_701073.apk
            //https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2019/10/08/comjuzhewww_1.0.0Beta_0493c6f9-09cd-5d8f-a297-97a7cca061a2.apk
            //http://video.haodanku.com/95ec3a0a93f144790a8e777eb0c69d9d?attname=1568698684.mp4
//            val url="https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2019/10/08/comjuzhewww_1.0.0Beta_0493c6f9-09cd-5d8f-a297-97a7cca061a2.apk"
            val url =
                "https://s.beta.myapp.com/myapp/rdmexp/exp/file2/2019/11/27/comjuzhewww_1.1.5_31a81b9c-303e-599a-a94c-6228df3dcf00.apk"

            if (it.tag.toString().toBoolean()) {
                HttpService.cancelTask(url)
                it.tag = false
                Toast.makeText(this, "已取消", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            HttpService.Builder(url)
                .tag(url)
                .downloadBreakpoint(true)/*断点下载：不调用此方法默认为true*/
                .get()
                .enqueue(object : OnDownloadListener() {
                    override fun onStart() {
                        it.tag = true
                        Log.e("HttpService", "onStart")
                    }

                    override fun onLoading(
                        key: String,
                        bytesRead: Long,
                        totalCount: Long,
                        isDone: Boolean
                    ) {

                        tv1.text = String.format("下载文件：%d/%d", bytesRead, totalCount)
                    }

                    override fun onFailure(e: Throwable, isNetworkError: Boolean) {
                        e.printStackTrace()
                        Log.e("HttpService", "onFailure")
                    }

                    override fun onResponse(value: File?) {
                        tv1.text = String.format("下载完成：%s", value!!.absolutePath)
                    }

                    override fun onEnd() {
                        Log.e("HttpService", "onEnd")
                    }

                })
        }
        tv2.setOnClickListener {
            /*上传*/
            var token =
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIwIjoiaWQiLCJzdWIiOjU4LCJpc3MiOiJodHRwOi8vZGV2LmppcnVhbm9zLmNvbS9hcGkvbG9naW4tYnktcGhvbmUiLCJpYXQiOjE1Njg2MzIwMzQsImV4cCI6MTU5OTczNjAzNCwibmJmIjoxNTY4NjMyMDM0LCJqdGkiOiJWZjlJeElVZW9pMDY2ZndwIn0.i3UO2OL1IPiQ-7GTVxlJg9S66kiyJ8K0RQfaKft8pU4"
            HttpService.Builder("http://dev.jiruanos.com/api/user/avatarUpdate")
                .addHeader("Authorization", token)
//                .addParams("file", File(Utils.saveSDCardPath + File.separatorChar + "weixin673android1360.apk"))
//                .addParams("file2", File(Utils.saveSDCardPath + File.separatorChar + "weixin673android1360.apk"))
                .addParams(
                    "avatar",
                    File("/storage/emulated/0/CacheQuickAndroid/SampleCropImage.png")
                )
                .addParams("token", token)
//                .addParams("userName", "151*****066")
//                .addParams("passWord", "888888")
                .enqueue(object : OnUploadingListener<String>() {

                    override fun onStart() {
                        super.onStart()
                    }

                    override fun onLoading(
                        key: String,
                        bytesRead: Long,
                        totalCount: Long,
                        isDone: Boolean
                    ) {
                        tv2.text = String.format("上传文件[%s]：%d/%d", key, bytesRead, totalCount)
//                                        Log.d("HttpService",String.format("正在上传[%s]：%s/%s", key, bytesRead.toString(), totalCount.toString()))

                        if ("file" == key && isDone) Log.e("HttpService", "file上传完成")
                        else if ("file2" == key && isDone) Log.e("HttpService", "file2上传完成")
                    }

                    override fun onResponse(value: String?) {
                        tv2.text = String.format("上传完成：%s", value)
//                        Log.e("HttpService",value)
                    }

                    override fun onFailure(e: Throwable, isNetworkError: Boolean) {
                        Log.e("HttpService", "上传错误")
                        e.printStackTrace()
                    }

                    override fun onEnd() {
                        Log.e("HttpService", "上传结束")
                        super.onEnd()
                    }

                })
        }
        tv3.setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
    }
}
