CREATE TABLE IF NOT EXISTS perfil_usuario {
    id_perfil_usuario INTEGER PRIMARY KEY UNIQUE NOT NULL,
    descricao_perfil TEXT NOT NULL UNIQUE,
}

CREATE TABLE IF NOT EXISTS usuarios {
    id_usuario INTEGER PRIMARY KEY UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    login TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    id_perfil_usuario INTEGER,
    CONSTRAINT fk_perfil_usuario FOREIGN KEY (id_perfil_usuario) REFERENCES perfil_usuario (id_perfil_usuario)
}

