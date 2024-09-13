import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

export function useGetMostTimeDuosData() {
    return useQuery({
        queryKey: ['most-time-duos'],
        queryFn: async () => {
            const response = await axios.get('http://localhost:8080/participations/all-time');
            return response.data;
        },
        staleTime: 10000 
    });
}