import { useParams } from "react-router-dom";

export default function TeamDetails() {
    const {teamId} = useParams();

    return (
        <h1>Team with {teamId}</h1>
    )
}