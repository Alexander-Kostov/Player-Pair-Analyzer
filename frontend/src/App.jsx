import { Route, Routes } from "react-router-dom"
import Home from "./components/Home"
import Teams from "./components/teams/Teams"
import Players from "./components/players/Players"
import SingleMatchComponent from "./components/tournament/MatchDetails"
import TeamDetails from "./components/teams//TeamDetails"
import Participations from "./components/Participations"
import LastingDuosAll from "./components/lasting-duos/LastingDuosAll";
import LastingDuosFromDifferentTeams from "./components/lasting-duos/LastingDuosFromDifferentTeams";
import Header from "./components/Header"

function App() {

    return (
        <>
            <Header/>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/teams" element={<Teams />} />
                <Route path="/teams/:teamId" element={<TeamDetails />} />

                <Route path="/players" element={<Players />} />

                <Route path="/matches/:matchId" element={<SingleMatchComponent />} />

                <Route path="/participations" element={<Participations />} />
                <Route path="/participations/lasting-duos" element={<LastingDuosAll />} />
                <Route path="/participations/lasting-duos-from-different-teams" element={<LastingDuosFromDifferentTeams />} />
            </Routes>
        </>
    )
}

export default App
