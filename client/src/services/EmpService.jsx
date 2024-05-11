import axios from 'axios';

const REST_API_URL = 'http://localhost:8080/api/employee';

export const listEmps = () => axios.get(REST_API_URL);

export const createEmp = (employee) => axios.post(REST_API_URL,employee)
