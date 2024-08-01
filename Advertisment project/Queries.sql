SELECT campaign_id, name
FROM internetadvertisement.campaign
WHERE CURRENT_DATE BETWEEN start_date AND end_date;


SELECT contact_info
FROM internetadvertisement.advertisers
WHERE industry_type = 'Technology';


SELECT campaign_id, (CAST(clicks AS FLOAT) / impressions) AS ctr
FROM internetadvertisement.performance;


SELECT slot_id, website_url, slot_location, slot_type, number_of_ads, slot_height, slot_width
FROM internetadvertisement.ad_slot
         JOIN internetadvertisement.website ON ad_slot.website_url = website.url
WHERE website.traffic_avg > 100000;


SELECT bills.bill_id, bills.bill_amount, bills.date_issued
FROM internetadvertisement.bills
         JOIN internetadvertisement.campaign ON bills.campaign_id = campaign.campaign_id
         JOIN internetadvertisement.advertisement_campaign ON campaign.campaign_id = advertisement_campaign.campaign_id
         JOIN internetadvertisement.advertisers ON advertisement_campaign.advertiser_id = advertisers.advertiser_id
WHERE advertisers.industry_type = 'Finance';


SELECT DISTINCT ad_slot.slot_id
FROM internetadvertisement.ad_slot
         JOIN internetadvertisement.click ON ad_slot.slot_id = click.ad_slot
         JOIN internetadvertisement.performance ON click.performance_campaign_id = performance.campaign_id
WHERE (CAST(performance.clicks AS FLOAT) / performance.impressions) > 0.05
ORDER BY slot_id;


SELECT advertisers.advertiser_id, advertisers.name
FROM internetadvertisement.advertisers
WHERE NOT EXISTS (SELECT 1
                  FROM internetadvertisement.advertisement_campaign
                           JOIN internetadvertisement.campaign
                                ON advertisement_campaign.campaign_id = campaign.campaign_id
                  WHERE advertisement_campaign.advertiser_id = advertisers.advertiser_id
                    AND CURRENT_DATE BETWEEN campaign.start_date AND campaign.end_date)
ORDER BY advertiser_id;


SELECT advertisers.advertiser_id, advertisers.name, SUM(bills.bill_amount) AS total_money_spent
FROM internetadvertisement.bills
JOIN internetadvertisement.campaign ON bills.campaign_id = campaign.campaign_id
JOIN internetadvertisement.advertisement_campaign ON campaign.campaign_id = advertisement_campaign.campaign_id
JOIN internetadvertisement.advertisers ON advertisement_campaign.advertiser_id = advertisers.advertiser_id
GROUP BY advertisers.advertiser_id, advertisers.name
ORDER BY advertiser_id;


SELECT campaign.campaign_id, campaign.name
FROM internetadvertisement.campaign
         JOIN internetadvertisement.campaign_demographics
              ON campaign.campaign_demographics_id = campaign_demographics.id
WHERE campaign_demographics.gender = 'Female'
  AND campaign_demographics.age_min <= 18
  AND campaign_demographics.age_max >= 24
  AND campaign_demographics.location = 'New York';


SELECT campaign_id, name
FROM internetadvertisement.campaign
WHERE budget > 50000;
