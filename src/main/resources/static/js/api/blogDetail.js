var vm = new Vue({
    el: "#app",
    data: {
        blogDetail: "", // 博客详细信息
    },
    methods: {
        // 获得参数
        getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        },
        loadBlogDetail() {
            let id = this.getQueryString("id");
            axios.get("/api/blog/getDetail?id=" + id).then(res => {
                this.blogDetail = res.data
            })
        }
    },
    created() {
        this.loadBlogDetail();
    }
})