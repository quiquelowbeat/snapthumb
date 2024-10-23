CREATE TABLE ai_backgounds (
    uuid UUID PRIMARY KEY,
    url TEXT NOT NULL,
    prompt TEXT NOT NULL,
    title TEXT NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    registered_at TIMESTAMP NOT NULL
);

COMMENT ON TABLE ai_backgounds IS 'Stores AI-generated background images';
COMMENT ON COLUMN ai_backgounds.uuid IS 'Unique identifier for the AI background';
COMMENT ON COLUMN ai_backgounds.url IS 'URL of the AI-generated background image';
COMMENT ON COLUMN ai_backgounds.prompt IS 'Prompt used to generate the AI background';
COMMENT ON COLUMN ai_backgounds.title IS 'Title of the AI background';
COMMENT ON COLUMN ai_backgounds.description IS 'Description of the AI background';
COMMENT ON COLUMN ai_backgounds.created_at IS 'Timestamp when the AI background was created';
COMMENT ON COLUMN ai_backgounds.registered_at IS 'Timestamp when the AI background was registered in the system';