import apiClient from "@/core/utils/apiClient";

class AuthService {

    login =  (user:any) => {
            return apiClient.post("/auth/login",user)
                .then(resp => resp.data)
                .catch(error => error.response.data)

    }
}

export default new AuthService();