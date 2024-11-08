CREATE TABLE ai_backgrounds (
    uuid UUID PRIMARY KEY,
    url TEXT NOT NULL,
    prompt TEXT NOT NULL,
    title TEXT NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    registered_at TIMESTAMP NOT NULL
);

COMMENT ON TABLE ai_backgrounds IS 'Stores AI-generated background images';
COMMENT ON COLUMN ai_backgrounds.uuid IS 'Unique identifier for the AI background';
COMMENT ON COLUMN ai_backgrounds.url IS 'URL of the AI-generated background image';
COMMENT ON COLUMN ai_backgrounds.prompt IS 'Prompt used to generate the AI background';
COMMENT ON COLUMN ai_backgrounds.title IS 'Title of the AI background';
COMMENT ON COLUMN ai_backgrounds.description IS 'Description of the AI background';
COMMENT ON COLUMN ai_backgrounds.created_at IS 'Timestamp when the AI background was created';
COMMENT ON COLUMN ai_backgrounds.registered_at IS 'Timestamp when the AI background was registered in the system';