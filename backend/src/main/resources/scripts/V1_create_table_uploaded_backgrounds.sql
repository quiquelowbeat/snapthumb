CREATE TABLE uploaded_backgounds (
    uuid UUID PRIMARY KEY,
    url TEXT NOT NULL,
    title TEXT NOT NULL,
    description TEXT,
    uploaded_at TIMESTAMP NOT NULL,
    registered_at TIMESTAMP NOT NULL
);

COMMENT ON TABLE uploaded_backgounds IS 'Stores uploaded background images';
COMMENT ON COLUMN uploaded_backgounds.uuid IS 'Unique identifier for the uploaded background';
COMMENT ON COLUMN uploaded_backgounds.url IS 'URL of the uploaded background image';
COMMENT ON COLUMN uploaded_backgounds.prompt IS 'Prompt used to generate the uploaded background';
COMMENT ON COLUMN uploaded_backgounds.title IS 'Title of the uploaded background';
COMMENT ON COLUMN uploaded_backgounds.description IS 'Description of the uploaded background';
COMMENT ON COLUMN uploaded_backgounds.uploaded_at IS 'Timestamp when the uploaded background was created';
COMMENT ON COLUMN uploaded_backgounds.registered_at IS 'Timestamp when the uploaded background was registered in the system';