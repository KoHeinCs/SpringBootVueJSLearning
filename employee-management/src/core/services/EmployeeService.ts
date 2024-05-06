import apiClient from "@/core/utils/apiClient";
import Employee from "@/core/types/Employee";


class EmployeeService {
    // get all employees
    getAllEmployees = ():Promise<Employee[]> => {
        return apiClient
            .get("/employee/all")
            .then((resp) =>  resp.data.data)
    }

    save = (employee:Employee) => {
        return apiClient.post("/employee/create",employee).then((resp) => resp.data)
    }

    getEmployeeById = (id:any):Promise<Employee> => {
            return apiClient
                .get(`/employee/find/${id}`)
                .then((resp)=> resp.data.data)
    }

    deleteEmployeeById = async (id:any) => {
        return await apiClient
            .delete(`/employee/delete/${id}`)
            .then((resp)=> resp.data)
    }

    updateEmployeeById =(id:any,employee:Employee) => {
        return apiClient.post(`/employee/update/${id}`,employee)
            .then((resp)=> resp.data)
    }


}

export default new EmployeeService();