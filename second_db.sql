PGDMP  	    8            	    |         	   second_db    16.4    16.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16397 	   second_db    DATABASE     }   CREATE DATABASE second_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE second_db;
                postgres    false            �            1259    16398    person    TABLE     �   CREATE TABLE public.person (
    uuid integer NOT NULL,
    name character varying(100),
    balance real,
    email character varying(500)
);
    DROP TABLE public.person;
       public         heap    postgres    false            �            1259    16405    auto_uuid_inc    SEQUENCE     ~   CREATE SEQUENCE public.auto_uuid_inc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 $   DROP SEQUENCE public.auto_uuid_inc;
       public          postgres    false    215            �           0    0    auto_uuid_inc    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.auto_uuid_inc OWNED BY public.person.uuid;
          public          postgres    false    216            �            1259    16406    person_uuid_seq    SEQUENCE     �   ALTER TABLE public.person ALTER COLUMN uuid ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.person_uuid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �          0    16398    person 
   TABLE DATA           <   COPY public.person (uuid, name, balance, email) FROM stdin;
    public          postgres    false    215   \       �           0    0    auto_uuid_inc    SEQUENCE SET     <   SELECT pg_catalog.setval('public.auto_uuid_inc', 1, false);
          public          postgres    false    216            �           0    0    person_uuid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.person_uuid_seq', 10, true);
          public          postgres    false    217                       2606    16402    person person_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (uuid);
 <   ALTER TABLE ONLY public.person DROP CONSTRAINT person_pkey;
       public            postgres    false    215            �   u   x�5�A
�0����a$�Xu׺T�t�@���@)��Iw?�<�b�-����p��}���|�B��`*ƍK�����(5{��\Z�bt(��\���F����%j4f�c�����!�,�     