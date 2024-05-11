const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm69aye/",
            name: "ssm69aye",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm69aye/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宠物店商城小程序"
        } 
    }
}
export default base
