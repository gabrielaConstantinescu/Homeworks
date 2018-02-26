create table INPUT_TABLE (
	id 			INTEGER auto_increment PRIMARY KEY,
	name        VARCHAR(10),
	date_in     DATETIME,
	date_out    DATETIME
);

create table OUTPUT_TABLE (
	id 			INTEGER auto_increment PRIMARY KEY,
	name        VARCHAR(50),
	minutes     REAL
);

insert into INPUT_TABLE (name, date_in, date_out) values ('Cristi', PARSEDATETIME('26 Jan 2018, 10:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'), PARSEDATETIME('26 Jan 2018, 06:30:14 PM','dd MMM yyyy, hh:mm:ss a','en'));
insert into INPUT_TABLE (name, date_in, date_out) values ('Adi', PARSEDATETIME('26 Jan 2018, 09:10:00 AM','dd MMM yyyy, hh:mm:ss a','en'), PARSEDATETIME('26 Jan 2018, 05:30:14 PM','dd MMM yyyy, hh:mm:ss a','en'));
insert into INPUT_TABLE (name, date_in, date_out) values ('Sorin', PARSEDATETIME('24 Jan 2018, 08:50:00 AM','dd MMM yyyy, hh:mm:ss a','en'), PARSEDATETIME('26 Jan 2018, 05:40:14 PM','dd MMM yyyy, hh:mm:ss a','en'));
insert into INPUT_TABLE (name, date_in, date_out) values ('Marius', PARSEDATETIME('25 Jan 2018, 08:30:00 AM','dd MMM yyyy, hh:mm:ss a','en'), PARSEDATETIME('26 Jan 2018, 05:00:14 PM','dd MMM yyyy, hh:mm:ss a','en'));