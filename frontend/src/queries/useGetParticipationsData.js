import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetParticipationsData() {
    return useQuery({
        queryKey: ['all-participations'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/participations/all');
            return response.data;
        },
        staleTime: 10000 
    });
}