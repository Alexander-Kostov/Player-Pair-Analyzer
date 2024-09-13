import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import { useParams } from 'react-router-dom';

export function useGetMatchDetails() {
    const { matchId } = useParams();

    return useQuery({
        queryKey: ['match-details', matchId],
        queryFn: async () => {
            const response = await axios.get(`http://localhost:8080/meets/${matchId}/details`);
            return response.data;
        },
        staleTime: 10000, 
        enabled: !!matchId 
    });
}