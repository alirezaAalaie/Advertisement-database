INSERT INTO internetadvertisement.campaign_demographics (age_min, age_max, location, gender, prior_behaviour, id) VALUES
(18, 24, 'New York', 'Male', 'Frequent online shopper', 1),
(25, 34, 'California', 'Female', 'Travel enthusiast', 2),
(35, 44, 'Texas', 'Other', 'Gadget lover', 3),
(45, 54, 'Florida', 'Male', 'Sports fan', 4),
(55, 64, 'New York', 'Female', 'Health conscious', 5),
(65, 74, 'Ohio', 'Male', 'Luxury buyer', 6),
(18, 24, 'New York', 'Female', 'Student', 7),
(25, 34, 'Washington', 'Other', 'Tech savvy', 8),
(35, 44, 'Nevada', 'Female', 'Gamer', 9),
(45, 54, 'Arizona', 'Male', 'Fitness enthusiast', 10);

INSERT INTO internetadvertisement.website_demographics (age_min, age_max, gender, id) VALUES
(18, 24, 'Male', 1),
(25, 34, 'Female', 2),
(35, 44, 'Other', 3),
(45, 54, 'Male', 4),
(55, 64, 'Female', 5),
(65, 74, 'Male', 6),
(18, 24, 'Female', 7),
(25, 34, 'Other', 8),
(35, 44, 'Female', 9),
(45, 54, 'Male', 10);

INSERT INTO internetadvertisement.catalog_demographics (age_min, age_max, gender, id) VALUES
(18, 24, 'Male', 1),
(25, 34, 'Female', 2),
(35, 44, 'Other', 3),
(45, 54, 'Male', 4),
(55, 64, 'Female', 5),
(65, 74, 'Male', 6),
(18, 24, 'Female', 7),
(25, 34, 'Other', 8),
(35, 44, 'Female', 9),
(45, 54, 'Male', 10);

INSERT INTO internetadvertisement.campaign (budget, campaign_id, start_date, end_date, name, campaign_demographics_id) VALUES
(10000, 1, '2024-01-01', '2024-06-30', 'Winter Sale Campaign', 1),
(15000, 2, '2024-02-01', '2024-07-31', 'Spring Travel Campaign', 2),
(20000, 3, '2024-03-01', '2024-08-31', 'Gadget Launch Campaign', 3),
(25000, 4, '2024-04-01', '2024-09-30', 'Summer Sports Campaign', 4),
(30000, 5, '2024-05-01', '2024-10-31', 'Health Awareness Campaign', 5),
(35000, 6, '2024-06-01', '2024-11-30', 'Luxury Products Campaign', 6),
(40000, 7, '2024-07-01', '2024-12-31', 'Back to School Campaign', 7),
(45000, 8, '2024-08-01', '2025-01-31', 'Tech Expo Campaign', 8),
(50000, 9, '2024-09-01', '2025-02-28', 'Gaming Tournament Campaign', 9),
(55000, 10, '2024-10-01', '2025-03-31', 'Fitness Challenge Campaign', 10);

INSERT INTO internetadvertisement.goals (campaign_id, description, goal_id) VALUES
(1, 'Increase sales by 20%', 1),
(2, 'Generate 5000 leads', 2),
(3, 'Boost website traffic by 30%', 3),
(4, 'Improve brand awareness', 4),
(5, 'Increase customer engagement', 5),
(6, 'Launch new product successfully', 6),
(7, 'Expand market reach', 7),
(8, 'Promote seasonal discounts', 8),
(9, 'Increase app downloads', 9),
(10, 'Gain social media followers', 10);

INSERT INTO internetadvertisement.sms_providers (provider_name, sms_price) VALUES
('Provider A', 1),
('Provider B', 2),
('Provider C', 3),
('Provider D', 4),
('Provider E', 5),
('Provider F', 6),
('Provider G', 7),
('Provider H', 8),
('Provider I', 9),
('Provider J', 10);

INSERT INTO internetadvertisement.sms_campaign (sms_campaign_id, message_text, price, provider_name, campaign_id) VALUES
(1, 'Discount on Winter Sale', 100, 'Provider A', 1),
(2, 'Spring Travel Offers', 150, 'Provider B', 2),
(3, 'New Gadget Launch', 200, 'Provider C', 3),
(4, 'Summer Sports Discount', 250, 'Provider D', 4),
(5, 'Health Tips and Offers', 300, 'Provider E', 5),
(6, 'Luxury Product Promotion', 350, 'Provider F', 6),
(7, 'Back to School Sale', 400, 'Provider G', 7),
(8, 'Tech Expo Invitation', 450, 'Provider H', 8),
(9, 'Gaming Tournament Info', 500, 'Provider I', 9),
(10, 'Fitness Challenge Sign Up', 550, 'Provider J', 10);

INSERT INTO internetadvertisement."user" (user_id, location, name, age) VALUES
(1, 'New York', 'John Doe', 30),
(2, 'California', 'Jane Smith', 25),
(3, 'Texas', 'Alex Johnson', 35),
(4, 'Florida', 'Chris Lee', 40),
(5, 'Illinois', 'Patricia Brown', 45),
(6, 'Ohio', 'Michael Davis', 50),
(7, 'Georgia', 'Jennifer Wilson', 28),
(8, 'Washington', 'William Martinez', 32),
(9, 'Nevada', 'Linda Anderson', 29),
(10, 'Arizona', 'Robert Thomas', 33);

INSERT INTO internetadvertisement.sim_card (sim_number, user_id) VALUES
(111111, 1),
(222222, 2),
(333333, 3),
(444444, 4),
(555555, 5),
(666666, 6),
(777777, 7),
(888888, 8),
(999999, 9),
(101010, 10);

INSERT INTO internetadvertisement.sms (text, send_date, is_recieved, is_seen, reaction, sms_id, sim_number, provider_name) VALUES
('Winter Sale Alert', '2024-01-01', 1, TRUE, 'Interested', 1, 111111, 'Provider A'),
('Travel Deals Available', '2024-02-01', 1, TRUE, 'Excited', 2, 222222, 'Provider B'),
('New Gadget Discount', '2024-03-01', 1, FALSE, 'Intrigued', 3, 333333, 'Provider C'),
('Sports Gear Sale', '2024-04-01', 0, FALSE, 'Neutral', 4, 444444, 'Provider D'),
('Health Products Offer', '2024-05-01', 1, TRUE, 'Happy', 5, 555555, 'Provider E'),
('Luxury Item Sale', '2024-06-01', 1, FALSE, 'Interested', 6, 666666, 'Provider F'),
('School Supplies Discount', '2024-07-01', 1, TRUE, 'Excited', 7, 777777, 'Provider G'),
('Tech Expo Invitation', '2024-08-01', 1, FALSE, 'Intrigued', 8, 888888, 'Provider H'),
('Gaming Event Info', '2024-09-01', 1, TRUE, 'Excited', 9, 999999, 'Provider I'),
('Fitness Challenge Sign Up', '2024-10-01', 1, TRUE, 'Interested', 10, 101010, 'Provider J');

INSERT INTO internetadvertisement.sim_operator (sim_number, provider_name) VALUES
(111111, 'Provider A'),
(222222, 'Provider B'),
(333333, 'Provider C'),
(444444, 'Provider D'),
(555555, 'Provider E'),
(666666, 'Provider F'),
(777777, 'Provider G'),
(888888, 'Provider H'),
(999999, 'Provider I'),
(101010, 'Provider J');

INSERT INTO internetadvertisement.personalized_sms (sms_campaign_id, user_id, send_time, message_text) VALUES
(1, 1, '2024-01-01', 'Hi John, check out our Winter Sale!'),
(2, 2, '2024-02-01', 'Hi Jane, special travel deals just for you!'),
(3, 3, '2024-03-01', 'Hi Alex, do not miss our new gadget launch!'),
(4, 4, '2024-04-01', 'Hi Chris, grab your summer sports gear now!'),
(5, 5, '2024-05-01', 'Hi Patricia, stay healthy with our products!'),
(6, 6, '2024-06-01', 'Hi Michael, enjoy our luxury items on sale!'),
(7, 7, '2024-07-01', 'Hi Jennifer, back to school discounts are here!'),
(8, 8, '2024-08-01', 'Hi William, join us at the Tech Expo!'),
(9, 9, '2024-09-01', 'Hi Linda, get the latest gaming event info!'),
(10, 10, '2024-10-01', 'Hi Robert, sign up for our fitness challenge!');

INSERT INTO internetadvertisement.bills (bill_id, bill_status, bill_rate, bill_amount, date_issued, campaign_id) VALUES
(1, 'Paid', 0.15, 1500, '2024-01-01', 1),
(2, 'Pending', 0.20, 2000, '2024-02-01', 2),
(3, 'Overdue', 0.25, 2500, '2024-03-01', 3),
(4, 'Paid', 0.30, 3000, '2024-04-01', 4),
(5, 'Pending', 0.35, 3500, '2024-05-01', 5),
(6, 'Overdue', 0.40, 4000, '2024-06-01', 6),
(7, 'Paid', 0.45, 4500, '2024-07-01', 7),
(8, 'Pending', 0.50, 5000, '2024-08-01', 8),
(9, 'Overdue', 0.55, 5500, '2024-09-01', 9),
(10, 'Paid', 0.60, 6000, '2024-10-01', 10),
(11, 'Paid', 0.20, 10000, '2024-10-02', 2);

INSERT INTO internetadvertisement.advertisers (advertiser_id, industry_type, contact_info, name) VALUES
(1, 'Retail', 'contact@retail.com', 'Retailer A'),
(2, 'Travel', 'contact@travel.com', 'Travel Agency B'),
(3, 'Technology', 'contact@tech.com', 'Tech Company C'),
(4, 'Sports', 'contact@sports.com', 'Sports Gear D'),
(5, 'Health', 'contact@health.com', 'Health Products E'),
(6, 'Luxury', 'contact@luxury.com', 'Luxury Goods F'),
(7, 'Education', 'contact@education.com', 'Education Supplies G'),
(8, 'Finance', 'contact@events.com', 'Event Organizer H'),
(9, 'Gaming', 'contact@gaming.com', 'Gaming Company I'),
(10, 'Fitness', 'contact@fitness.com', 'Fitness Products J');

INSERT INTO internetadvertisement.advertisement_campaign (campaign_id, advertiser_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO internetadvertisement.publishers (publisher_id, digital_property_info, traffic_data) VALUES
(1, 'Website A', 'High'),
(2, 'Website B', 'Medium'),
(3, 'Website C', 'Low'),
(4, 'Website D', 'High'),
(5, 'Website E', 'Medium'),
(6, 'Website F', 'Low'),
(7, 'Website G', 'High'),
(8, 'Website H', 'Medium'),
(9, 'Website I', 'Low'),
(10, 'Website J', 'High');

INSERT INTO internetadvertisement.website (url, traffic_avg, website_demographics_id, publisher_id) VALUES
('https://siteA.com', 100000.5, 1, 1),
('https://siteB.com', 800.5, 2, 2),
('https://siteC.com', 600.5, 3, 3),
('https://siteD.com', 400.5, 4, 4),
('https://siteE.com', 200.5, 5, 5),
('https://siteF.com', 100.5, 6, 6),
('https://siteG.com', 50.5, 7, 7),
('https://siteH.com', 30.5, 8, 8),
('https://siteI.com', 20.5, 9, 9),
('https://siteJ.com', 10.5, 10, 10);

INSERT INTO internetadvertisement.advertisement_catalog (catalog_id, price, status, catalog_demographics_id, publisher_id) VALUES
(1, 500, 'Available', 1, 1),
(2, 1000, 'Booked', 2, 2),
(3, 1500, 'Available', 3, 3),
(4, 2000, 'Booked', 4, 4),
(5, 2500, 'Available', 5, 5),
(6, 3000, 'Booked', 6, 6),
(7, 3500, 'Available', 7, 7),
(8, 4000, 'Booked', 8, 8),
(9, 4500, 'Available', 9, 9),
(10, 5000, 'Booked', 10, 10);

INSERT INTO internetadvertisement.advert_format (formatname, website_id) VALUES
('Banner', 'https://siteA.com'),
('Video', 'https://siteB.com'),
('Popup', 'https://siteC.com'),
('Interstitial', 'https://siteD.com'),
('Native', 'https://siteE.com'),
('Banner', 'https://siteF.com'),
('Video', 'https://siteG.com'),
('Popup', 'https://siteH.com'),
('Interstitial', 'https://siteI.com'),
('Native', 'https://siteJ.com');

INSERT INTO internetadvertisement.advert_program (website_url, catalog_id) VALUES
('https://siteA.com', 1),
('https://siteB.com', 2),
('https://siteC.com', 3),
('https://siteD.com', 4),
('https://siteE.com', 5),
('https://siteF.com', 6),
('https://siteG.com', 7),
('https://siteH.com', 8),
('https://siteI.com', 9),
('https://siteJ.com', 10);

INSERT INTO internetadvertisement.transaction_history (transaction_status, transaction_amount, transaction_type, publisher_id, advertiser_id) VALUES
('Completed', '1000', 'Credit', 1, 1),
('Pending', '2000', 'Debit', 2, 2),
('Failed', '1500', 'Credit', 3, 3),
('Completed', '2500', 'Debit', 4, 4),
('Pending', '3000', 'Credit', 5, 5),
('Failed', '3500', 'Debit', 6, 6),
('Completed', '4000', 'Credit', 7, 7),
('Pending', '4500', 'Debit', 8, 8),
('Failed', '5000', 'Credit', 9, 9),
('Completed', '5500', 'Debit', 10, 10);

INSERT INTO internetadvertisement.available_ad_opportunities (content, publisher_id) VALUES
('Banner Ad Slot', 1),
('Video Ad Slot', 2),
('Popup Ad Slot', 3),
('Interstitial Ad Slot', 4),
('Native Ad Slot', 5),
('Banner Ad Slot', 6),
('Video Ad Slot', 7),
('Popup Ad Slot', 8),
('Interstitial Ad Slot', 9),
('Native Ad Slot', 10);

INSERT INTO internetadvertisement.ad_slot (slot_id, website_url, slot_location, slot_type, number_of_ads, slot_height, slot_width) VALUES
(1, 'https://siteA.com', 'Top', 'Banner', 5, 250.5, 300.5),
(2, 'https://siteB.com', 'Side', 'Video', 4, 200.5, 250.5),
(3, 'https://siteC.com', 'Bottom', 'Popup', 3, 150.5, 200.5),
(4, 'https://siteD.com', 'Top', 'Interstitial', 2, 100.5, 150.5),
(5, 'https://siteE.com', 'Side', 'Native', 1, 50.5, 100.5),
(6, 'https://siteF.com', 'Bottom', 'Banner', 5, 250.5, 300.5),
(7, 'https://siteG.com', 'Top', 'Video', 4, 200.5, 250.5),
(8, 'https://siteH.com', 'Side', 'Popup', 3, 150.5, 200.5),
(9, 'https://siteI.com', 'Bottom', 'Interstitial', 2, 100.5, 150.5),
(10, 'https://siteJ.com', 'Top', 'Native', 1, 50.5, 100.5);

INSERT INTO internetadvertisement.performance (successful_clicks, impressions, clicks, campaign_id) VALUES
(100, 1000, 50, 1),
(200, 2000, 150, 2),
(300, 3000, 250, 3),
(400, 4000, 350, 4),
(500, 5000, 450, 5),
(600, 6000, 550, 6),
(700, 7000, 650, 7),
(800, 8000, 750, 8),
(900, 9000, 850, 9),
(1000, 10000, 950, 10);

INSERT INTO internetadvertisement.click (is_successful, time, user_id, ad_slot, performance_campaign_id) VALUES
(true, '2024-01-01', 1, 1, 1),
(false, '2024-01-02', 2, 2, 2),
(true, '2024-01-03', 3, 3, 3),
(false, '2024-01-04', 4, 4, 4),
(true, '2024-01-05', 5, 5, 5),
(false, '2024-01-06', 6, 6, 6),
(true, '2024-01-07', 7, 7, 7),
(false, '2024-01-08', 8, 8, 8),
(true, '2024-01-09', 9, 9, 9),
(false, '2024-01-10', 10, 10, 10);

INSERT INTO internetadvertisement.video_ads (video_file, geographical_info, vad_id, item_name, item_price, population, behaviour) VALUES
('videoA.mp4', 'Urban', 1, 'Item A', 500, 'High', 'Positive'),
('videoB.mp4', 'Suburban', 2, 'Item B', 1000, 'Medium', 'Neutral'),
('videoC.mp4', 'Rural', 3, 'Item C', 1500, 'Low', 'Negative'),
('videoD.mp4', 'Urban', 4, 'Item D', 2000, 'High', 'Positive'),
('videoE.mp4', 'Suburban', 5, 'Item E', 2500, 'Medium', 'Neutral'),
('videoF.mp4', 'Rural', 6, 'Item F', 3000, 'Low', 'Negative'),
('videoG.mp4', 'Urban', 7, 'Item G', 3500, 'High', 'Positive'),
('videoH.mp4', 'Suburban', 8, 'Item H', 4000, 'Medium', 'Neutral'),
('videoI.mp4', 'Rural', 9, 'Item I', 4500, 'Low', 'Negative'),
('videoJ.mp4', 'Urban', 10, 'Item J', 5000, 'High', 'Positive');

INSERT INTO internetadvertisement.banner_ads (ad_png, geographical_info, bad_id, item_name, item_price, population, behaviour) VALUES
('bannerA.png', 'Urban', 1, 'Item A', 500, 'High', 'Positive'),
('bannerB.png', 'Suburban', 2, 'Item B', 1000, 'Medium', 'Neutral'),
('bannerC.png', 'Rural', 3, 'Item C', 1500, 'Low', 'Negative'),
('bannerD.png', 'Urban', 4, 'Item D', 2000, 'High', 'Positive'),
('bannerE.png', 'Suburban', 5, 'Item E', 2500, 'Medium', 'Neutral'),
('bannerF.png', 'Rural', 6, 'Item F', 3000, 'Low', 'Negative'),
('bannerG.png', 'Urban', 7, 'Item G', 3500, 'High', 'Positive'),
('bannerH.png', 'Suburban', 8, 'Item H', 4000, 'Medium', 'Neutral'),
('bannerI.png', 'Rural', 9, 'Item I', 4500, 'Low', 'Negative'),
('bannerJ.png', 'Urban', 10, 'Item J', 5000, 'High', 'Positive');

INSERT INTO internetadvertisement.video_reservation (end_time, start_time, price, ad_slot_id, vad_id) VALUES
('2024-01-15', '2024-01-01', 500, 1, 1),
('2024-02-15', '2024-02-01', 1000, 2, 2),
('2024-03-15', '2024-03-01', 1500, 3, 3),
('2024-04-15', '2024-04-01', 2000, 4, 4),
('2024-05-15', '2024-05-01', 2500, 5, 5),
('2024-06-15', '2024-06-01', 3000, 6, 6),
('2024-07-15', '2024-07-01', 3500, 7, 7),
('2024-08-15', '2024-08-01', 4000, 8, 8),
('2024-09-15', '2024-09-01', 4500, 9, 9),
('2024-10-15', '2024-10-01', 5000, 10, 10);

INSERT INTO internetadvertisement.banner_reservation (end_time, start_time, price, ad_slot_id, bad_id) VALUES
('2024-01-15', '2024-01-01', 500, 1, 1),
('2024-02-15', '2024-02-01', 1000, 2, 2),
('2024-03-15', '2024-03-01', 1500, 3, 3),
('2024-04-15', '2024-04-01', 2000, 4, 4),
('2024-05-15', '2024-05-01', 2500, 5, 5),
('2024-06-15', '2024-06-01', 3000, 6, 6),
('2024-07-15', '2024-07-01', 3500, 7, 7),
('2024-08-15', '2024-08-01', 4000, 8, 8),
('2024-09-15', '2024-09-01', 4500, 9, 9),
('2024-10-15', '2024-10-01', 5000, 10, 10);

INSERT INTO internetadvertisement.campaign_videos (campaign_id, vad_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO internetadvertisement.campaign_banners (campaign_id, bad_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);