
interface HttpResponse {
    response:RespDTO
}

interface RespDTO{
    data:any;
    httpStatusCode:any;
    httpStatus:any;
    message:any;
    localDateTime:any;
}


export default HttpResponse;