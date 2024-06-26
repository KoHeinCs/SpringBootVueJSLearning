import axios, {AxiosInstance} from "axios"

const API_URL = "http://localhost:9090/api";

const axiosInstance: AxiosInstance = axios.create({
    baseURL: API_URL,
    headers: {
        "Content-Type": "application/json",
    }
});


axiosInstance.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("jwtToken");
        config.headers.Authorization = `Bearer ${token}`;
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
)

export default axiosInstance;