import { Route, Routes } from "react-router-dom"
import Home from "./components/Home"
import Teams from "./components/Teams"
import Players from "./components/Players"
import Participations from "./components/Participations"
import LastingDuos from "./components/LastingDuos"
import Layout from "./components/Layout"
import Matches from "./components/Matches"
import SingleMatchComponent from "./components/SignleMatchComponent"

function App() {

    return (
        <Layout>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/teams" element={<Teams />} />
                <Route path="/players" element={<Players />} />
                
                <Route path="/matches" element={<Matches/>} />
                <Route path="/matches/:matchId" element={<SingleMatchComponent />} />

                <Route path="/participations" element={<Participations />} />
                <Route path="/participations/lasting-duos" element={<LastingDuos />} />
            </Routes>
        </Layout>
    )
}

export default App
