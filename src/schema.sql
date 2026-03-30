

create table venues(
                       id serial primary key,
                       venue_name varchar(50) unique,
                       location varchar(100)
);

create table event(
                      event_id serial primary key,
                      event_name varchar(50) unique,
                      event_date date,
                      venue_id integer references venues(id)
);

create table attendees(
                          attendee_id serial primary key,
                          attendee_name varchar(50) unique,
                          email varchar(100) unique
);

create table event_attendee(
                               attendee_id integer references attendees(attendee_id),
                               event_id integer references event(event_id),
                               primary key(attendee_id, event_id)
)