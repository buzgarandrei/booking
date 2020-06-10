select r.id,
/*       r.available,
       r.id_hotel,
       r.nr_of_adults,
       r.nr_of_kids,
       r.id_room_description*/
       p.amount,
       p.start_date,
       p.end_date,

       CASE
           WHEN '2019-12-17' >= p.start_date AND '2020-01-02' >= p.end_date THEN DATEDIFF(p.end_date, '2019-12-17') + 1
           WHEN '2019-12-17' <= p.start_date AND '2020-01-02' >= p.end_date THEN DATEDIFF(p.end_date, p.start_date) + 1
           WHEN '2019-12-17' <= p.start_date AND '2020-01-02' <= p.end_date THEN DATEDIFF('2020-01-02', p.start_date) + 1
           END as no_of_days,

       (
           SELECT CASE
                      WHEN '2019-12-17' >= p.start_date AND '2020-01-02' >= p.end_date
                          THEN DATEDIFF(p.end_date, '2019-12-17')
                      WHEN '2019-12-17' <= p.start_date AND '2020-01-02' >= p.end_date
                          THEN DATEDIFF(p.end_date, p.start_date)
                      WHEN '2019-12-17' <= p.start_date AND '2020-01-02' <= p.end_date
                          THEN DATEDIFF('2020-01-02', p.start_date)
                      END
           FROM price pp
           WHERE pp.id = p.id
       ) * p.amount

from rooms r
         inner join hotels h on r.id_hotel = h.id
         inner join hotel_facilities hf on h.id = hf.id_hotel
         inner join facility hfacility on hf.id_facility = hfacility.id
         inner join room_facility rf on r.id = rf.id_room
         inner join facility rfacility on rf.id_facility = rfacility.id

         inner join price p on r.id = p.id_room

where r.available = 1
  and r.nr_of_adults = 2
  and r.nr_of_kids = 2
  and h.city = 'Cluj-Napoca'
  and hfacility.facility_name = 'POOL'
  and rfacility.facility_name = 'WIFI'
  and (p.start_date between '2020-06-28' and '2020-07-08' or p.end_date between '2019-06-28' and '2020-07-08')

/*group by r.id
having ()
*/
