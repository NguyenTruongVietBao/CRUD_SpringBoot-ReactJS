import { useEffect, useState } from "react"
import {listEmps} from '../services/EmpService'
import {useNavigate} from 'react-router-dom'
const ListEmp = () => {

    const [emps, setEmps] = useState([]);
    const navigator = useNavigate();

    // fetch data
    useEffect(()=>{
        listEmps().then((res)=>{
            setEmps(res.data)
        })
    })

    //create link
    function addEmp(){
        navigator('/add-employee')
    }

  return (
    <div className="container">
        <h1 className="text-center">List Employee</h1>
        <button onClick={addEmp} className="btn btn-success">Add Emp</button>
        <table className="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actios</th>
                </tr>
            </thead>
            <tbody>
                {
                    emps.map(emp => 
                        <tr key={emp.id}>
                            <td>{emp.id}</td>
                            <td>{emp.name}</td>
                            <td>{emp.email}</td>
                            <td>
                                <button type="button" className="btn btn-warning">Update</button>
                                <button type="button" className="btn btn-danger">Delete</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmp