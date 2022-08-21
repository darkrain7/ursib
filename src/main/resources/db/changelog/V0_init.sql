CREATE TABLE test(
    id BIGSERIAL PRIMARY KEY,
    document_id BIGINT NOT NULL,
    document_date DATE NOT NULL,
    dictionary_id BIGINT NOT NULL,
    dictionary_name TEXT NOT NULL,
    sort_order BIGINT NOT NULL
);