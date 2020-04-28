select r.id,
       r.available,

       r.nr_of_adults,
       r.nr_of_kids,

       p.amount,
       p.start_date,
       p.end_date,

       SUM(
                   (
                       SELECT
                           CASE
                               WHEN '2019-12-17' >= p.start_date AND '2020-01-02' >= p.end_date THEN DATEDIFF(p.end_date, '2019-12-17') + 1
                               WHEN '2019-12-17' <= p.start_date AND '2020-01-02' >= p.end_date THEN DATEDIFF(p.end_date, p.start_date) + 1
                               WHEN '2019-12-17' <= p.start_date AND '2020-01-02' <= p.end_date THEN DATEDIFF('2020-01-02', p.start_date) + 1
                               END
                       FROM price pp
                       WHERE pp.id = p.id
                   ) * p.amount
           ) as total

from rooms r
         inner join hotels h on r.id_hotel = h.id

         inner join hotel_facilities hf on h.id = hf.id_hotel
         inner join facility h_facility on hf.id_facility = h_facility.id
         inner join room_facility rf on r.id = rf.id_room
         inner join facility r_facility on rf.id_facility = r_facility.id

         inner join price p on r.id = p.id_room

where r.available = 1
  and r.nr_of_adults = 2
  and r.nr_of_kids = 2
  and h.city = 'Cluj-Napoca'
  and h_facility.facility_name = 'POOL'
  and r_facility.facility_name = 'WIFI'
  and (p.start_date between '2019-12-17' and '2020-01-02' or p.end_date between '2019-12-17' and '2020-01-02')

group by r.id
having (total > 10)
order by total
