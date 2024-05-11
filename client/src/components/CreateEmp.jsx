import { useState } from "react"
import { createEmp } from "../services/EmpService"
import {useNavigate} from 'react-router-dom'
export default function CreateEmp() {
    const [name, setName] = useState('')
    const [email, setEmail] = useState('')
    const navigator = useNavigate();
    function handleName(e){
        setName(e.target.value)
    }
    function handleEmail(e){
        setEmail(e.target.value)
    }
    function saveEmployee(e){
        e.preventDefault();
        const emp = {name, email};
        console.log(emp);
        createEmp(emp).then((res)=> {
            console.log(res.data);
            navigator('/')
        })
    }
  return (
    <div className="container">
        <div className="row">
            <div className="card mt-4">
                <h2 className="text-center">Add emp</h2>
                <div className="card-body">
                    <form>
                        <div className="form-group mb-2">
                            <label className='form-label'>Name</label>
                            <input
                                type="text"
                                placeholder="Enter name"
                                name="firstName"
                                value={name}
                                className="form-control"
                                onChange={handleName}
                            />
                        </div>
                        <div className="form-group mb-2">
                            <label className='form-label'>Email</label>
                            <input
                                type="text"
                                placeholder="Enter email"
                                name="email"
                                value={email}
                                className="form-control"
                                onChange={handleEmail}
                            />
                        </div>
                        <button className="btn btn-success" onClick={saveEmployee}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}
