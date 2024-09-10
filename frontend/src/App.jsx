import Header from "./components/Header"
import { Route, Routes } from "react-router-dom"
import Home from "./components/Home"
import Teams from "./components/Teams"
import Players from "./components/Players"
import Participations from "./components/Participations"
import LastingDuos from "./components/LastingDuos"

function App() {

    return (
        <>
            <Header />

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/teams" element={<Teams />} />
                <Route path="/players" element={<Home />} />
                <Route path="/matches" element={<Players/>} />
                <Route path="/participations" element={<Participations />} />
                <Route path="/participations/lasting-duos" element={<LastingDuos />} />
            </Routes>
        </>
    )
}

export default App
