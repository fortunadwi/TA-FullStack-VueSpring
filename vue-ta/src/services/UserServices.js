
import http from "../http-common"

class userService {
    create(data){
        return http.post("user/insert",data);
    }
}

export default new userService();