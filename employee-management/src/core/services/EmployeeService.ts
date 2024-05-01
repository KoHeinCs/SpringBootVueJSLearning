import apiClient from "@/core/utils/apiClient";
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

    deleteEmployeeById = async (id:any) => {
        return await apiClient
            .delete(`/employee/delete/${id}`)
            .then((resp)=> resp.data)
            .catch((err) => console.log(err))
    }

    updateEmployeeById =(id:any,employee:Employee) => {
        return apiClient.post(`/employee/update/${id}`,employee)
            .then((resp)=> resp.data)
            .catch((error)=> console.log(error))
    }


}

export default new EmployeeService();