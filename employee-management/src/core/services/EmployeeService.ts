import apiClient from "@/core/utils/apiClient";
import HttpResponse from "@/core/types/HttpResponse";
import Employee from "@/core/types/Employee";


class EmployeeService {
    // get all employees
    getAllEmployees = ():Promise<Employee[]> => {
        return apiClient
            .get("/employee/all")
            .then((resp) => resp.data.response.data )
            .catch((err)=> console.log(err))

    }

    save = (employee:Employee) => {
        return apiClient.post("/employee/create",employee).then((resp) => resp.data)
    }

    getEmployeeById = (id:any):Promise<Employee> => {
            return apiClient
                .get(`/employee/find/${id}`)
                .then((resp)=> resp.data.response.data)
                .catch((err)=>{console.log(err)})
    }


}

export default new EmployeeService();