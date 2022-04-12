var vm = new Vue({
    el: "#app",
    data: {
        blogList: []
    },
    methods: {
        loadBlogList() {
            axios.get("/api/archives/load").then(res => {
                this.blogList = res.data
                console.log(this.blogList)
            })
        }
    },
    mounted() {
        this.loadBlogList();
    }
})