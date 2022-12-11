CREATE TABLE TYPE
(
    ID_TYPE NUMBER(8),
    NOMBRE  VARCHAR(100),
    CONSTRAINT ID_TYPE PRIMARY KEY (ID_TYPE)
);

COMMENT ON COLUMN TYPE.ID_TYPE IS 'The identifier for this resource.';
COMMENT ON COLUMN TYPE.NOMBRE IS 'The name for this resource.';

CREATE TABLE POKEMON
(
    ID_POKEMON NUMBER(8),
    NOMBRE     VARCHAR(100),
    ALTURA     NUMBER(8, 2),
    PESO       NUMBER(8, 2),
    TIPO_1     NUMBER(8),
    TIPO_2     NUMBER(8),
    CONSTRAINT ID_POKEMON PRIMARY KEY (ID_POKEMON),
    FOREIGN KEY (TIPO_1) REFERENCES TYPE (ID_TYPE),
    FOREIGN KEY (TIPO_2) REFERENCES TYPE (ID_TYPE)
);

COMMENT ON COLUMN POKEMON.ID_POKEMON IS 'The identifier for this resource.';
COMMENT ON COLUMN POKEMON.NOMBRE IS 'The name for this resource.';
COMMENT ON COLUMN POKEMON.ALTURA IS 'The height of this Pokémon in decimetres.';
COMMENT ON COLUMN POKEMON.PESO IS 'The weight of this Pokémon in hectograms.';
COMMENT ON COLUMN POKEMON.TIPO_1 IS 'First type this Pokémon has.';
COMMENT ON COLUMN POKEMON.TIPO_2 IS 'Second type this Pokémon has.';

CREATE TABLE SPRITE
(
    ID_SPRITE            NUMBER(8),
    FRONTAL_DEFAULT      VARCHAR(500),
    FRONTAL_FEMALE       VARCHAR(500),
    FRONTAL_SHINY        VARCHAR(500),
    FRONTAL_SHINY_FEMALE VARCHAR(500),
    CONSTRAINT ID_SPRITE PRIMARY KEY (ID_SPRITE)
);

COMMENT ON COLUMN SPRITE.ID_SPRITE IS 'The identifier for this resource.';
COMMENT ON COLUMN SPRITE.FRONTAL_DEFAULT IS 'The default depiction of this Pokémon from the front in battle.';
COMMENT ON COLUMN SPRITE.FRONTAL_FEMALE IS 'The female depiction of this Pokémon from the front in battle.';
COMMENT ON COLUMN SPRITE.FRONTAL_SHINY IS 'The shiny depiction of this Pokémon from the front in battle.';
COMMENT ON COLUMN SPRITE.FRONTAL_SHINY_FEMALE IS 'The shiny female depiction of this Pokémon from the front in battle.';

