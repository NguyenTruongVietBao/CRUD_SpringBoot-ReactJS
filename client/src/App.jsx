  import CreateEmp from './components/CreateEmp'
import ListEmp from './components/ListEmp'
  import {Routes, Route} from 'react-router-dom'

function App() {

  return (
    <div>
      <Routes>
        <Route path='/' element= {<ListEmp/>}></Route>
        <Route path='/employee' element= {<ListEmp/>}></Route>
        <Route path='/add-employee' element= {<CreateEmp/>}></Route>
      </Routes>
    </div>
  )
}

export default App
