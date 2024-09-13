import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import { useParams } from 'react-router-dom';

export function useGetTeamDetails() {
    const { teamId } = useParams();

    return useQuery({
        queryKey: ['team-details', teamId],
        queryFn: async () => {
            const response = await axios.get(`http://localhost:8080/teams/${teamId}`);
            return response.data;
        },
        staleTime: 10000, 
        enabled: !!teamId 
    });
}