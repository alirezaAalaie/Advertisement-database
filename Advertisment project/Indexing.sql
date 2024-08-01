-- Index on start_date
CREATE INDEX idx_campaign_start_date ON internetadvertisement.campaign (start_date);

-- Index on end_date
CREATE INDEX idx_campaign_end_date ON internetadvertisement.campaign (end_date);

-- Index on industry_type
CREATE INDEX idx_advertisers_industry_type ON internetadvertisement.advertisers (industry_type);

-- Composite index on (campaign_id, bill_id)
CREATE INDEX idx_bills_campaign_id_bill_id ON internetadvertisement.bills (campaign_id, bill_id);
