import { useGetMostTimeDuosFromDifferentTeams } from '../queries/useGetMostTimeDuosDataFromDifferentTeams';
import LastingDuosTable from './LastingDuosTable';

export default function LastingDuosFromDifferentTeams() {
    const { data, error, isLoading } = useGetMostTimeDuosFromDifferentTeams();
    console.log(data)

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error fetching data: {error.message}</div>;
    }

    return (
        <LastingDuosTable
            data={data}
            title="Players With Most Mutual Time From Different Teams"
            iconClass="fa-solid fa-backward"
            navigateTo="/participations/lasting-duos"
            divPageClass="previous-page"
        />
    );
}