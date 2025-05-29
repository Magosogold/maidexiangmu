const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot10gv7/",
            name: "springboot10gv7",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot10gv7/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于BS招投标管理系统 "
        } 
    }
}
export default base
