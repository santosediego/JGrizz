INSERT INTO TB_USER (PASSWORD, USERNAME) VALUES ('senha123', 'Victoria Barros');
INSERT INTO TB_USER (PASSWORD, USERNAME) VALUES ('senha123', 'Diego Santos');

INSERT INTO TB_RECEIPT_TYPE (DESCRIPTION, ACTIVE) VALUES ('PIX', 'TRUE');
INSERT INTO TB_RECEIPT_TYPE (DESCRIPTION, ACTIVE) VALUES ('PAYPAL', 'TRUE');

INSERT INTO TB_ILLUSTRATION (COMMENTS, DESCRIPTION, PRICE) VALUES ('Loren Ipson loren ipson loren ipson', 'Ilustração estilo A com um personagem', 120.00 );
INSERT INTO TB_ILLUSTRATION (COMMENTS, DESCRIPTION, PRICE) VALUES ('Loren Ipson loren ipson loren ipson', 'Ilustração estilo B com dois personagem', 80.00 );
INSERT INTO TB_ILLUSTRATION (COMMENTS, DESCRIPTION, PRICE) VALUES ('Loren Ipson loren ipson loren ipson', 'Ilustração estilo C com cinco personagem', 200.00 );
INSERT INTO TB_ILLUSTRATION (COMMENTS, DESCRIPTION, PRICE) VALUES ('Loren Ipson loren ipson loren ipson', 'Ilustração estilo D com um personagem', 80.00 );
INSERT INTO TB_ILLUSTRATION (COMMENTS, DESCRIPTION, PRICE) VALUES ('Loren Ipson loren ipson loren ipson', 'Ilustração estilo E com dois personagem', 150.00 );
INSERT INTO TB_ILLUSTRATION (COMMENTS, DESCRIPTION, PRICE) VALUES ('Loren Ipson loren ipson loren ipson', 'Ilustração estilo F com três personagem', 120.00 );

INSERT INTO TB_CLIENT (EMAIL, NAME, NETWORK, PHONE) VALUES ('pedro@email.com', 'Pedro Gomes', '@pgomes', '34985647895');
INSERT INTO TB_CLIENT (EMAIL, NAME, NETWORK, PHONE) VALUES ('maria@email.com', 'Maria Souza', '@msouza', '11965419872');
INSERT INTO TB_CLIENT (EMAIL, NAME, NETWORK, PHONE) VALUES ('lucas@email.com', 'Lucas Silva', '@lsilva', '21932497856');
INSERT INTO TB_CLIENT (EMAIL, NAME, NETWORK, PHONE) VALUES ('gabriela@email.com', 'Gabriela Jesus', '@gjesus', '11996548721');
INSERT INTO TB_CLIENT (EMAIL, NAME, NETWORK, PHONE) VALUES ('juliana@email.com', 'Juliana Alves', '@jalves', '14987569872');
INSERT INTO TB_CLIENT (EMAIL, NAME, NETWORK, PHONE) VALUES ('gabriel@email.com', 'Gabriel Bernardes', '@gbernardes', '21987563218');

INSERT INTO TB_ORDER (DESCRIPTION, COMMENTS, CLIENT_ID, PAYMENT, RECEIPT_TYPE_ID, DELIVERY, CREATION_DATE) VALUES ('Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Aenean euismod tincidunt sapien, non efficitur dui dignissim non. Proin ac enim eget risus posuere consequat. Aliquam erat volutpat. Donec a dui vitae odio commodo vestibulum vel nec erat.',1, 2, 1, '2024-08-29', NOW());
INSERT INTO TB_ORDER (DESCRIPTION, COMMENTS, CLIENT_ID, PAYMENT, RECEIPT_TYPE_ID, DELIVERY, CREATION_DATE) VALUES ('Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Aenean euismod tincidunt sapien, non efficitur dui dignissim non. Proin ac enim eget risus posuere consequat. Aliquam erat volutpat. Donec a dui vitae odio commodo vestibulum vel nec erat.',2, 2, 2, '2024-08-29', NOW());

INSERT INTO ILLUSTRATION_ORDER (PRICE, QUANTITY, DISCOUNT, ILLUSTRATION_ID, ORDER_ID) VALUES (120.00, 1, 0, 1, 1);
INSERT INTO ILLUSTRATION_ORDER (PRICE, QUANTITY, DISCOUNT, ILLUSTRATION_ID, ORDER_ID) VALUES (120.00, 1, 0, 1, 2);
INSERT INTO ILLUSTRATION_ORDER (PRICE, QUANTITY, DISCOUNT, ILLUSTRATION_ID, ORDER_ID) VALUES (80.00, 1, 0, 2, 2);
