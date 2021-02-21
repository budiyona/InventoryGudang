let init ={
    statusLogin: false,

}

const loginReducer = (state=init,action)=>{
    switch (action.type) {
        case "LOGIN":
            const {username,password}=action.data
            console.log("adataatatta",username);
            if(username==='admin'&&password==='admin'){
                return {
                    statusLogin: true
                }
            }else{
                alert("username/password salah")
                window.location.href = "/403"
                break;
            }
        case "LOGOUT":
            return{
                statusLogin : false
            }
    
        default:
            return init;
    }
}

export default loginReducer