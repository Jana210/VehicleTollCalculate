DROP TABLE IF EXISTS TOLL_PRICE_PER_HOUR_TAB;
DROP TABLE IF EXISTS YEAR_HOLIDAY_TAB;
CREATE TABLE TOLL_PRICE_PER_HOUR_TAB (
    PRICE_ID numeric(3),
	HOUR_MIN_FROM numeric(4),
	HOUR_MIN_TO numeric(4),
    PRICE numeric(3)
   );
   
CREATE TABLE YEAR_HOLIDAY_TAB (
    HOLIDAY_ID numeric(3),
	YEAR numeric(4),
	MONTH numeric(2),
    DAY numeric(2)
   );
   
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(1,600,629,9);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(2,630,659,16);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(3,700,759,22);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(4,800,829,16);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(5,830,1459,9);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(6,1500,1529,16);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(7,1530,1659,22);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(8,1700,1759,16);
INSERT INTO TOLL_PRICE_PER_HOUR_TAB(PRICE_ID,HOUR_MIN_FROM,HOUR_MIN_TO,PRICE) VALUES(9,1800,1829,9);

INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(1,2020,1,1);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(2,2020,1,6);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(3,2020,4,9);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(4,2020,4,10);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(5,2020,4,13);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(6,2020,4,30);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(7,2020,5,1);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(8,2020,6,15);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(9,2020,6,19);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(10,2020,10,30);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(11,2020,12,24);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(12,2020,12,25);
INSERT INTO YEAR_HOLIDAY_TAB(HOLIDAY_ID,YEAR,MONTH,DAY) VALUES(13,2020,12,31);
