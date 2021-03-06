PGDMP                          y           DBreservation    13.2    13.2 /    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16477    DBreservation    DATABASE     l   CREATE DATABASE "DBreservation" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_Morocco.1252';
    DROP DATABASE "DBreservation";
                postgres    false            ?            1259    16560    users    TABLE       CREATE TABLE public.users (
    user_id integer NOT NULL,
    nom character varying(50) NOT NULL,
    prenom character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(50) NOT NULL,
    role_id integer NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?            1259    16577    admin_table    TABLE     Z   CREATE TABLE public.admin_table (
    idadmin integer NOT NULL
)
INHERITS (public.users);
    DROP TABLE public.admin_table;
       public         heap    postgres    false    203            ?            1259    16583 	   apprenant    TABLE     y   CREATE TABLE public.apprenant (
    idapprenant integer NOT NULL,
    nbr_reservation integer
)
INHERITS (public.users);
    DROP TABLE public.apprenant;
       public         heap    postgres    false    203            ?            1259    16636    nbrplacetable    TABLE     ?   CREATE TABLE public.nbrplacetable (
    id_nbrplace integer NOT NULL,
    idadmin integer NOT NULL,
    nombre integer NOT NULL,
    date_ajout date NOT NULL
);
 !   DROP TABLE public.nbrplacetable;
       public         heap    postgres    false            ?            1259    16634    nbrplacetable_id_nbrplace_seq    SEQUENCE     ?   CREATE SEQUENCE public.nbrplacetable_id_nbrplace_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.nbrplacetable_id_nbrplace_seq;
       public          postgres    false    209            ?           0    0    nbrplacetable_id_nbrplace_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.nbrplacetable_id_nbrplace_seq OWNED BY public.nbrplacetable.id_nbrplace;
          public          postgres    false    208            ?            1259    16623    reservation    TABLE     ?   CREATE TABLE public.reservation (
    id_reservation integer NOT NULL,
    idapprenant integer,
    date_reservation date NOT NULL,
    confirmation boolean NOT NULL
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            ?            1259    16621    reservation_id_reservation_seq    SEQUENCE     ?   CREATE SEQUENCE public.reservation_id_reservation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.reservation_id_reservation_seq;
       public          postgres    false    207            ?           0    0    reservation_id_reservation_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.reservation_id_reservation_seq OWNED BY public.reservation.id_reservation;
          public          postgres    false    206            ?            1259    16508    roles    TABLE     j   CREATE TABLE public.roles (
    role_id integer NOT NULL,
    role_type character varying(50) NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            ?            1259    16506    roles_role_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.roles_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.roles_role_id_seq;
       public          postgres    false    201            ?           0    0    roles_role_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.roles_role_id_seq OWNED BY public.roles.role_id;
          public          postgres    false    200            ?            1259    16558    users_user_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false    203            ?           0    0    users_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;
          public          postgres    false    202            >           2604    16580    admin_table user_id    DEFAULT     t   ALTER TABLE ONLY public.admin_table ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
 B   ALTER TABLE public.admin_table ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    202    204            ?           2604    16586    apprenant user_id    DEFAULT     r   ALTER TABLE ONLY public.apprenant ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
 @   ALTER TABLE public.apprenant ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    202    205            A           2604    16639    nbrplacetable id_nbrplace    DEFAULT     ?   ALTER TABLE ONLY public.nbrplacetable ALTER COLUMN id_nbrplace SET DEFAULT nextval('public.nbrplacetable_id_nbrplace_seq'::regclass);
 H   ALTER TABLE public.nbrplacetable ALTER COLUMN id_nbrplace DROP DEFAULT;
       public          postgres    false    208    209    209            @           2604    16626    reservation id_reservation    DEFAULT     ?   ALTER TABLE ONLY public.reservation ALTER COLUMN id_reservation SET DEFAULT nextval('public.reservation_id_reservation_seq'::regclass);
 I   ALTER TABLE public.reservation ALTER COLUMN id_reservation DROP DEFAULT;
       public          postgres    false    206    207    207            <           2604    16511    roles role_id    DEFAULT     n   ALTER TABLE ONLY public.roles ALTER COLUMN role_id SET DEFAULT nextval('public.roles_role_id_seq'::regclass);
 <   ALTER TABLE public.roles ALTER COLUMN role_id DROP DEFAULT;
       public          postgres    false    201    200    201            =           2604    16563    users user_id    DEFAULT     n   ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
 <   ALTER TABLE public.users ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    203    202    203            ?          0    16577    admin_table 
   TABLE DATA           ^   COPY public.admin_table (user_id, nom, prenom, email, password, role_id, idadmin) FROM stdin;
    public          postgres    false    204   ?5       ?          0    16583 	   apprenant 
   TABLE DATA           q   COPY public.apprenant (user_id, nom, prenom, email, password, role_id, idapprenant, nbr_reservation) FROM stdin;
    public          postgres    false    205   ?5       ?          0    16636    nbrplacetable 
   TABLE DATA           Q   COPY public.nbrplacetable (id_nbrplace, idadmin, nombre, date_ajout) FROM stdin;
    public          postgres    false    209   6       ?          0    16623    reservation 
   TABLE DATA           b   COPY public.reservation (id_reservation, idapprenant, date_reservation, confirmation) FROM stdin;
    public          postgres    false    207   66       ?          0    16508    roles 
   TABLE DATA           3   COPY public.roles (role_id, role_type) FROM stdin;
    public          postgres    false    201   S6       ?          0    16560    users 
   TABLE DATA           O   COPY public.users (user_id, nom, prenom, email, password, role_id) FROM stdin;
    public          postgres    false    203   p6       ?           0    0    nbrplacetable_id_nbrplace_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.nbrplacetable_id_nbrplace_seq', 1, false);
          public          postgres    false    208            ?           0    0    reservation_id_reservation_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.reservation_id_reservation_seq', 1, false);
          public          postgres    false    206            ?           0    0    roles_role_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.roles_role_id_seq', 1, false);
          public          postgres    false    200            ?           0    0    users_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);
          public          postgres    false    202            O           2606    16582    admin_table admin_table_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.admin_table
    ADD CONSTRAINT admin_table_pkey PRIMARY KEY (idadmin);
 F   ALTER TABLE ONLY public.admin_table DROP CONSTRAINT admin_table_pkey;
       public            postgres    false    204            Q           2606    16588    apprenant apprenant_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.apprenant
    ADD CONSTRAINT apprenant_pkey PRIMARY KEY (idapprenant);
 B   ALTER TABLE ONLY public.apprenant DROP CONSTRAINT apprenant_pkey;
       public            postgres    false    205            U           2606    16641     nbrplacetable nbrplacetable_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.nbrplacetable
    ADD CONSTRAINT nbrplacetable_pkey PRIMARY KEY (id_nbrplace);
 J   ALTER TABLE ONLY public.nbrplacetable DROP CONSTRAINT nbrplacetable_pkey;
       public            postgres    false    209            S           2606    16628    reservation reservation_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id_reservation);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    207            C           2606    16513    roles roles_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (role_id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    201            E           2606    16515    roles roles_role_type_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_role_type_key UNIQUE (role_type);
 C   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_role_type_key;
       public            postgres    false    201            G           2606    16571    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    203            I           2606    16567    users users_nom_key 
   CONSTRAINT     M   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_nom_key UNIQUE (nom);
 =   ALTER TABLE ONLY public.users DROP CONSTRAINT users_nom_key;
       public            postgres    false    203            K           2606    16565    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    203            M           2606    16569    users users_prenom_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_prenom_key UNIQUE (prenom);
 @   ALTER TABLE ONLY public.users DROP CONSTRAINT users_prenom_key;
       public            postgres    false    203            X           2606    16642 (   nbrplacetable nbrplacetable_idadmin_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.nbrplacetable
    ADD CONSTRAINT nbrplacetable_idadmin_fkey FOREIGN KEY (idadmin) REFERENCES public.admin_table(idadmin);
 R   ALTER TABLE ONLY public.nbrplacetable DROP CONSTRAINT nbrplacetable_idadmin_fkey;
       public          postgres    false    209    2895    204            W           2606    16629 (   reservation reservation_idapprenant_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_idapprenant_fkey FOREIGN KEY (idapprenant) REFERENCES public.apprenant(idapprenant);
 R   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_idapprenant_fkey;
       public          postgres    false    2897    207    205            V           2606    16572    users users_role_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.roles(role_id);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_role_id_fkey;
       public          postgres    false    2883    203    201            ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?     