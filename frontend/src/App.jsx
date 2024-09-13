import { Route, Routes } from "react-router-dom"
import Home from "./components/Home"
import Teams from "./components/Teams"
import Players from "./components/Players"
import LastingDuos from "./components/LastingDuosAll"
import Layout from "./components/Layout"
import SingleMatchComponent from "./components/MatchDetails"
import TeamDetails from "./components/TeamDetails"
import LastingDuosFromDifferentTeams from "./components/LastingDuosFromDifferentTeams"
import Participations from "./components/Participations"

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
                <Route path="/participations/lasting-duos-from-different-teams" element={<LastingDuosFromDifferentTeams />} />
            </Routes>
        </Layout>
    )
}

export default App
