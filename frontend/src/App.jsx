import { Route, Routes } from "react-router-dom"
import Home from "./components/Home"
import Teams from "./components/Teams"
import Players from "./components/Players"
import Participations from "./components/Participations"
import LastingDuos from "./components/LastingDuos"
import Layout from "./components/Layout"
import SingleMatchComponent from "./components/MatchDetails"
import TeamDetails from "./components/TeamDetails"

function App() {

    return (
        <Layout>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/teams" element={<Teams />} />
                <Route path="/teams/:teamId" element={<TeamDetails />} />

                <Route path="/players" element={<Players />} />

                <Route path="/matches/:matchId" element={<SingleMatchComponent />} />

                <Route path="/participations" element={<Participations />} />
                <Route path="/participations/lasting-duos" element={<LastingDuos />} />
            </Routes>
        </Layout>
    )
}

export default App
