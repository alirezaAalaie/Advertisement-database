create table if not exists internetadvertisement.campaign_demographics
(
    age_min         integer not null,
    age_max         integer not null,
    location        varchar,
    gender          varchar,
    prior_behaviour varchar,
    id              integer not null
        constraint campaign_demographics_pk
            primary key
);

alter table internetadvertisement.campaign_demographics
    owner to postgres;

create table if not exists internetadvertisement.website_demographics
(
    age_min integer,
    age_max integer,
    gender  varchar,
    id      integer not null
        constraint website_demographics_pk
            primary key
);

alter table internetadvertisement.website_demographics
    owner to postgres;

create table if not exists internetadvertisement.catalog_demographics
(
    age_min integer,
    age_max integer,
    gender  varchar,
    id      integer not null
        constraint id
            primary key
);

alter table internetadvertisement.catalog_demographics
    owner to postgres;

create table if not exists internetadvertisement.campaign
(
    budget                   integer,
    campaign_id              integer not null
        constraint campaign_pk
            primary key,
    start_date               date,
    end_date                 date,
    name                     varchar,
    campaign_demographics_id integer
        constraint campaign_campaign_demographics_id_fk
            references internetadvertisement.campaign_demographics
);

alter table internetadvertisement.campaign
    owner to postgres;

create table if not exists internetadvertisement.goals
(
    campaign_id integer not null
        constraint goals_campaign_campaign_id_fk
            references internetadvertisement.campaign,
    description varchar,
    goal_id     integer not null
        constraint goals_pk
            primary key
);

alter table internetadvertisement.goals
    owner to postgres;

create table if not exists internetadvertisement.sms_providers
(
    provider_name varchar not null
        constraint sms_providers_pk
            primary key,
    sms_price     integer
);

alter table internetadvertisement.sms_providers
    owner to postgres;

create table if not exists internetadvertisement.sms_campaign
(
    sms_campaign_id integer not null
        constraint sms_campaign_pk
            unique,
    message_text    varchar,
    price           integer,
    provider_name   varchar not null
        constraint sms_campaign_sms_providers_provider_name_fk
            references internetadvertisement.sms_providers,
    campaign_id     integer not null
        constraint sms_campaign_campaign_campaign_id_fk
            references internetadvertisement.campaign,
    constraint sms_campaign_pk_2
        primary key (campaign_id, provider_name)
);

alter table internetadvertisement.sms_campaign
    owner to postgres;

create table if not exists internetadvertisement."user"
(
    user_id  integer not null
        constraint user_pk
            primary key,
    location varchar,
    name     varchar,
    age      integer
);

alter table internetadvertisement."user"
    owner to postgres;

create table if not exists internetadvertisement.sim_card
(
    sim_number integer not null
        constraint sim_card_pk
            primary key,
    user_id    integer
        constraint sim_card_user_user_id_fk
            references internetadvertisement."user"
);

alter table internetadvertisement.sim_card
    owner to postgres;

create table if not exists internetadvertisement.sms
(
    text          varchar,
    send_date     date,
    is_recieved   integer,
    is_seen       boolean,
    reaction      varchar,
    sms_id        integer not null
        constraint sms_uk
            unique,
    sim_number    integer not null
        constraint sms_sim_card_sim_number_fk
            references internetadvertisement.sim_card,
    provider_name varchar not null
        constraint sms_sms_providers_provider_name_fk
            references internetadvertisement.sms_providers,
    constraint sms_pk_1
        primary key (provider_name, sim_number)
);

alter table internetadvertisement.sms
    owner to postgres;

create table if not exists internetadvertisement.sim_operator
(
    sim_number    integer not null
        constraint sim_operator_sim_card_sim_number_fk
            references internetadvertisement.sim_card,
    provider_name varchar not null
        constraint sim_operator_sms_providers_provider_name_fk
            references internetadvertisement.sms_providers,
    constraint sim_operator_pk
        primary key (sim_number, provider_name)
);

alter table internetadvertisement.sim_operator
    owner to postgres;

create table if not exists internetadvertisement.personalized_sms
(
    sms_campaign_id integer not null
        constraint personalized_sms_sms_campaign_sms_campaign_id_fk
            references internetadvertisement.sms_campaign (sms_campaign_id),
    user_id         integer not null
        constraint personalized_sms_user_user_id_fk
            references internetadvertisement."user",
    send_time       date,
    message_text    varchar,
    constraint personalized_sms_pk
        primary key (user_id, sms_campaign_id)
);

alter table internetadvertisement.personalized_sms
    owner to postgres;

create table if not exists internetadvertisement.bills
(
    bill_id     integer not null,
    bill_status varchar,
    bill_rate   double precision,
    bill_amount integer,
    date_issued date,
    campaign_id integer not null
        constraint bills_campaign_campaign_id_fk
            references internetadvertisement.campaign,
    constraint bills_pk
        primary key (bill_id, campaign_id)
);

alter table internetadvertisement.bills
    owner to postgres;

create table if not exists internetadvertisement.advertisers
(
    advertiser_id integer not null
        constraint advertisers_pk
            primary key,
    industry_type varchar,
    contact_info  varchar,
    name          varchar
);

alter table internetadvertisement.advertisers
    owner to postgres;

create table if not exists internetadvertisement.advertisement_campaign
(
    campaign_id   integer not null
        constraint advertisement_campaign_campaign_campaign_id_fk
            references internetadvertisement.campaign,
    advertiser_id integer not null
        constraint advertisement_campaign_advertisers_advertiser_id_fk
            references internetadvertisement.advertisers,
    constraint advertisement_campaign_pk
        primary key (advertiser_id, campaign_id)
);

alter table internetadvertisement.advertisement_campaign
    owner to postgres;

create table if not exists internetadvertisement.publishers
(
    publisher_id          integer not null
        constraint publishers_pk
            primary key,
    digital_property_info varchar,
    traffic_data          varchar
);

alter table internetadvertisement.publishers
    owner to postgres;

create table if not exists internetadvertisement.website
(
    url                     varchar not null
        constraint website_pk
            primary key,
    traffic_avg             double precision,
    website_demographics_id integer not null
        constraint website_website_demographics_id_fk
            references internetadvertisement.website_demographics,
    publisher_id            integer not null
        constraint website_publishers_publisher_id_fk
            references internetadvertisement.publishers
);

alter table internetadvertisement.website
    owner to postgres;

create table if not exists internetadvertisement.advertisement_catalog
(
    catalog_id              integer not null
        constraint advertisement_catalog_pk
            primary key,
    price                   integer,
    status                  varchar,
    catalog_demographics_id integer not null
        constraint advertisement_catalog_catalog_demographics_id_fk
            references internetadvertisement.catalog_demographics,
    publisher_id            integer not null
        constraint advertisement_catalog_publishers_publisher_id_fk
            references internetadvertisement.publishers
);

alter table internetadvertisement.advertisement_catalog
    owner to postgres;

create table if not exists internetadvertisement.advert_format
(
    formatname varchar not null,
    website_id varchar not null
        constraint advert_format_pk
            primary key
        constraint advert_format_website_url_fk
            references internetadvertisement.website
);

alter table internetadvertisement.advert_format
    owner to postgres;

create table if not exists internetadvertisement.advert_program
(
    website_url varchar not null
        constraint advert_program_website_url_fk
            references internetadvertisement.website,
    catalog_id  integer not null
        constraint advert_program_advertisement_catalog_catalog_id_fk
            references internetadvertisement.advertisement_catalog,
    constraint advert_program_pk
        primary key (website_url, catalog_id)
);

alter table internetadvertisement.advert_program
    owner to postgres;

create table if not exists internetadvertisement.transaction_history
(
    transaction_status varchar,
    transaction_amount varchar not null,
    transaction_type   varchar not null,
    publisher_id       integer not null
        constraint transaction_history_publishers_publisher_id_fk
            references internetadvertisement.publishers,
    advertiser_id      integer not null
        constraint transaction_history_advertisers_advertiser_id_fk
            references internetadvertisement.advertisers,
    constraint transaction_history_pk
        primary key (advertiser_id, publisher_id)
);

alter table internetadvertisement.transaction_history
    owner to postgres;

create table if not exists internetadvertisement.available_ad_opportunities
(
    content      varchar not null,
    publisher_id integer not null
        constraint available_ad_opportunities_publishers_publisher_id_fk
            references internetadvertisement.publishers,
    constraint available_ad_opportunities_pk
        primary key (publisher_id, content)
);

alter table internetadvertisement.available_ad_opportunities
    owner to postgres;

create table if not exists internetadvertisement.ad_slot
(
    slot_id       integer not null
        constraint ad_slot_pk_2
            unique,
    website_url   varchar not null
        constraint ad_slot_website_url_fk
            references internetadvertisement.website,
    slot_location varchar,
    slot_type     varchar,
    number_of_ads integer,
    slot_height   double precision,
    slot_width    double precision,
    constraint ad_slot_pk
        primary key (website_url, slot_id)
);

alter table internetadvertisement.ad_slot
    owner to postgres;

create table if not exists internetadvertisement.performance
(
    successful_clicks integer,
    impressions       integer,
    clicks            integer,
    campaign_id       integer not null
        constraint performance_pk
            primary key
        constraint performance_campaign_campaign_id_fk
            references internetadvertisement.campaign
);

alter table internetadvertisement.performance
    owner to postgres;

create table if not exists internetadvertisement.click
(
    is_successful           boolean,
    time                    date    not null,
    user_id                 integer not null
        constraint click_user_user_id_fk
            references internetadvertisement."user",
    ad_slot                 integer
        constraint click_ad_slot_slot_id_fk
            references internetadvertisement.ad_slot (slot_id),
    performance_campaign_id integer
        constraint click_performance_campaign_id_fk
            references internetadvertisement.performance,
    constraint click_pk
        primary key (user_id, time)
);

alter table internetadvertisement.click
    owner to postgres;

create table if not exists internetadvertisement.video_ads
(
    video_file        varchar,
    geographical_info varchar,
    vad_id            integer not null
        constraint video_ads_pk
            primary key,
    item_name         varchar,
    item_price        integer,
    population        varchar,
    behaviour         varchar
);

alter table internetadvertisement.video_ads
    owner to postgres;

create table if not exists internetadvertisement.banner_ads
(
    ad_png            varchar,
    geographical_info varchar,
    bad_id            integer not null
        constraint banner_ads_pk
            primary key,
    item_name         varchar,
    item_price        integer,
    population        varchar,
    behaviour         varchar
);

alter table internetadvertisement.banner_ads
    owner to postgres;

create table if not exists internetadvertisement.video_reservation
(
    end_time   date    not null,
    start_time date    not null,
    price      integer,
    ad_slot_id integer not null
        constraint video_reservation_ad_slot_slot_id_fk
            references internetadvertisement.ad_slot (slot_id),
    vad_id     integer not null
        constraint video_reservation_video_ads_vad_id_fk
            references internetadvertisement.video_ads,
    constraint video_reservation_pk
        primary key (ad_slot_id, start_time, end_time, vad_id)
);

alter table internetadvertisement.video_reservation
    owner to postgres;

create table if not exists internetadvertisement.banner_reservation
(
    end_time   date    not null,
    start_time date    not null,
    price      integer,
    ad_slot_id integer not null
        constraint banner_reservation_ad_slot_slot_id_fk
            references internetadvertisement.ad_slot (slot_id),
    bad_id     integer not null
        constraint banner_reservation_banner_ads_bad_id_fk
            references internetadvertisement.banner_ads,
    constraint banner_reservation_pk
        primary key (ad_slot_id, start_time, end_time, bad_id)
);

alter table internetadvertisement.banner_reservation
    owner to postgres;

create table if not exists internetadvertisement.campaign_videos
(
    campaign_id integer
        constraint campaign_videos_campaign_campaign_id_fk
            references internetadvertisement.campaign,
    vad_id      integer not null
        constraint campaign_videos_pk
            primary key
        constraint campaign_videos_video_ads_vad_id_fk
            references internetadvertisement.video_ads
);

alter table internetadvertisement.campaign_videos
    owner to postgres;

create table if not exists internetadvertisement.campaign_banners
(
    campaign_id integer
        constraint campaign_banners_campaign_campaign_id_fk
            references internetadvertisement.campaign,
    bad_id      integer not null
        constraint campaign_banners_pk
            primary key
        constraint campaign_banners_banner_ads_bad_id_fk
            references internetadvertisement.banner_ads
);

alter table internetadvertisement.campaign_banners
    owner to postgres;