var vm = new Vue({
    el: "#app",
    data: {
        blogQueryParams: {
            pageNo: 1,
            pageSize: 4,
            total: 0,
            pages: 0,
            categoryId: 0
        },// 博客列表查询参数
        blogCategoryList: [], // 分类集合
        blogList: [], // 博客列表集合
        checkIndex: 0, // 被选中的分类
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
            axios.get("api/blog/load?pageNo=" + this.blogQueryParams.pageNo + "&pageSize=" + this.blogQueryParams.pageSize + "&categoryId=" + this.blogQueryParams.categoryId).then(res => {
                this.blogList = this.blogList.concat(res.data.records)
            })
        },
        // 切换分类
        changeCategory(categoryId, index) {
            this.checkIndex = index
            this.blogQueryParams.categoryId = categoryId
            this.blogList = []
            this.pageNo = 1
            this.loadBlogContent();
        }
    },
    created() {
        this.loadCategory();
        this.loadBlogContent();
    }
})