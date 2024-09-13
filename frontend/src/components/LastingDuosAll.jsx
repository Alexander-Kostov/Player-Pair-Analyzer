import { useGetMostTimeDuos } from '../queries/useGetMostTimeDuosData';
import '../css/lasting-duos.css';
import LastingDuosTable from './LastingDuosTable';

export default function LastingDuos() {

    const { data, error, isLoading } = useGetMostTimeDuos();

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error fetching data: {error.message}</div>;
    }


    return (
        <LastingDuosTable
            data={data}
            title="Players With Most Mutual Time"
            iconClass="fa-solid fa-forward"
            navigateTo="/participations/lasting-duos-from-different-teams"
            divPageClass="next-page"
        />
    )
}