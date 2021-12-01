var vm = new Vue({
    el: "#app",
    data: {
        blogCategoryList: [], // 分类集合
        blogList: [], // 博客列表集合
    },
    methods: {
        // 加载分类
        loadCategory() {
            axios.get("api/category/load").then(res => {
                this.blogCategoryList = res.data;
            })
        },
        // 加载博客内容
        loadBlogContent() {
            axios.get("api/blog/load").then(res => {
                console.log(res)
                this.blogList = res.data.records
            })
        }
    },
    created() {
        this.loadCategory();
        this.loadBlogContent();
    }
})