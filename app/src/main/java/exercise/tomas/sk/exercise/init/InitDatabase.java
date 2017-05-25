package exercise.tomas.sk.exercise.init;

import android.app.Application;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import exercise.tomas.sk.exercise.bo.dao.Entry;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.bo.dao.Type;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;

/**
 * Created by anx00283 on 18-May-17.
 */

public class InitDatabase extends Application {

    private List<String> uuids;
    private int counter;

    public InitDatabase() {
        counter = 0;

        uuids = new LinkedList<>();
        uuids.add("e066d1c3-8c26-4c2c-9160-734f2b3a7408");
        uuids.add("c1c37a31-2f68-47d0-8bb1-d786bab7af94");
        uuids.add("e2221960-c441-42ba-afeb-ba63ba22d50b");
        uuids.add("31286e87-a0ae-4563-a0f8-0786b106e485");
        uuids.add("17d4674b-4564-401e-b95e-45ae35e44869");
        uuids.add("3b2996be-371b-4188-a77e-b7afe2415a91");
        uuids.add("36ba894a-4f68-4546-9a28-8914b5e41c9d");
        uuids.add("08d31097-4299-433f-87ff-287e83d8b6f8");
        uuids.add("0975db27-7b5f-446f-80fa-059a7ff093fb");
        uuids.add("db8ec858-376d-4bbd-9504-d8803747b56e");
        uuids.add("0a500be1-0db6-4719-9674-114658f54923");
        uuids.add("1d9a5e90-9ce8-4a22-a390-4c19e6af833e");
        uuids.add("d63beac8-7978-427f-809c-cf05d3e2b61d");
        uuids.add("b5ae6651-7780-466f-b250-2810cb5b2314");
        uuids.add("2d04ba48-2f04-47f5-98b3-cb2ca72cc0af");
        uuids.add("7f34a739-da03-426b-952b-c115748dd12d");
        uuids.add("f9f01289-91a1-4fd6-8772-012fd475fe6a");
        uuids.add("f26da2c8-6043-4e77-9bea-2adee3bf45c4");
        uuids.add("0877ff17-a07d-4315-ba2b-3804ae899176");
        uuids.add("d3a8736c-5a39-424e-812b-43765b1ac01f");
        uuids.add("2f6cb452-7d13-4e65-9f4d-d31270f6d086");
        uuids.add("6dca71b4-c2b2-4898-be39-6922bd8b9b27");
        uuids.add("d9ad76c1-a7ff-4d88-aa4c-9408e81f15c4");
        uuids.add("bfe587f9-6179-4b20-a8e4-1399cda5dd8a");
        uuids.add("1f36a227-7add-4502-b924-8d6aaac14bfb");
        uuids.add("bfd995ae-4804-41dd-a7c9-fb763034e25b");
        uuids.add("27ea01f3-a50b-4604-b1af-536f0123593a");
        uuids.add("b27e6898-4ed1-41f1-9438-f90927f7a3ea");
        uuids.add("c833c0fa-497b-47bd-b00e-85c96d9fbeb0");
        uuids.add("115cfc4d-7afa-4663-b5d4-007c98c62d4b");
        uuids.add("3c2c6a02-e939-441e-9778-a8feb38e8f3c");
        uuids.add("2f204372-9d98-4cc8-a2b3-2d5023e9a8fe");
        uuids.add("79e4f22b-4902-4c21-8e3e-65e76df115a7");
        uuids.add("cf229310-f57a-4a8f-b8e5-eb3d810aab51");
        uuids.add("7434cd60-7428-4292-afa9-10bfd3931ea3");
        uuids.add("fed86619-dfa9-4fe4-9b72-5e42d060f285");
        uuids.add("67d6fdb1-f429-4a92-90f4-6befd6cb352f");
        uuids.add("f4619901-2733-4fd4-beb5-3cd50242b707");
        uuids.add("480a9ad2-2656-4d1a-ad22-420242f10192");
        uuids.add("00e8e63c-9f3e-455f-8e17-2f5124fdc275");
        uuids.add("1fd6ea2b-50de-4e65-90c3-056361511e60");
        uuids.add("b1ec59d5-4aab-4765-8a36-b16c71569224");
        uuids.add("0283a518-c8ed-4251-ba79-c5d08a8c2052");
        uuids.add("2b92e887-2bde-4cf8-82a9-42ac9f81f44e");
        uuids.add("123879f4-d56e-4c25-bb99-c6816b839c71");
        uuids.add("9f5cc77b-c97c-43fc-b50e-dcb3b912d1f5");
        uuids.add("33a74ffb-06f6-46cb-b8ec-b3d265e1375c");
        uuids.add("cd195e37-f205-4fd3-8b3a-4f6a4dee8cc2");
        uuids.add("5cfb6fa4-5097-4f1a-b831-7101d9f8c6e6");
        uuids.add("1680bbf0-b85a-4fbf-a2cb-030d4a2d2a1b");
        uuids.add("6ea92203-73e8-4e8e-9c13-8c4b39f60783");
        uuids.add("721340bd-e81c-48a1-bce1-907ffa66472d");
        uuids.add("0e6f0778-8aae-4fa7-a095-fa5e6dc4b0ee");
        uuids.add("6536792f-9157-440e-a6c5-0428283c3dd4");
        uuids.add("50b64337-39cc-4144-befe-d3f74bd1473f");
        uuids.add("6a2854ff-76b9-4a7b-821b-fc0ada3bfb6e");
        uuids.add("e7fac570-778a-4742-9436-edebd1917912");
        uuids.add("412e69b7-e1f3-4115-ba02-fe85be647728");
        uuids.add("72cdd085-7a73-4c6b-a7a9-21e663a8357e");
        uuids.add("8d18e339-3d76-4c56-be70-889d1d9b342d");
        uuids.add("f80c9445-dc15-4c89-9c48-1e06ef6d950c");
        uuids.add("2f9fc91d-df10-41c8-a982-92e9015885db");
        uuids.add("406617db-6258-40d5-815e-50420f49418b");
        uuids.add("ae7012ae-af9c-4e6d-9463-0c848f5346d1");
        uuids.add("2808eefa-bec0-48c0-809a-64cb0f4a3b37");
        uuids.add("c3edcd2d-70a3-4ee1-b918-fcfdd05f6c22");
        uuids.add("03b7a7d0-9f79-4ca7-aedb-508d0059b98c");
        uuids.add("110cac61-718c-4964-b5c6-e7de6906373b");
        uuids.add("9ea7f1ed-8c5f-4968-a5ff-eb0069643ced");
        uuids.add("6ff36b40-b212-4e34-b568-cd72212c8fc0");
        uuids.add("f331bad0-e449-4f6a-8bdf-66445bfdee03");
        uuids.add("5d66a2d7-c65f-4735-904a-7182a41b3f09");
        uuids.add("765410c4-7045-4111-92fa-ef98086d4aee");
        uuids.add("92cd44dd-2f13-4134-8be2-a008cda1b6a6");
        uuids.add("2186d5af-2cfe-4fcb-83cc-7dd8c1f10839");
        uuids.add("46b7c729-72ec-4e5c-baae-d9f211e61a55");
        uuids.add("07e128d7-37d3-46c9-872d-bfaa9a7e2635");
        uuids.add("19b8f0cf-1e8d-4d9f-9cd9-296f9ef45197");
        uuids.add("46cad61c-7fe3-406e-be2b-35788c1b6338");
        uuids.add("acd61dd5-3e50-4b03-b9a9-6b904d23b93a");
        uuids.add("7eca4c1d-38d0-4c90-83fd-f17d63a45351");
        uuids.add("9303e520-3e4f-4d9c-99af-9abe4c2c0d60");
        uuids.add("1a447942-6cce-48bd-ad5f-803841b1a288");
        uuids.add("002d179b-f1be-4b99-97f5-4236e3a1366d");
        uuids.add("973969d8-83de-4b52-8ce8-c3f9c9d8758b");
        uuids.add("acbe4d79-92e6-4860-8afe-b4c244d8cd70");
        uuids.add("a02ec45f-3df1-492f-ac57-f628fea00471");
        uuids.add("47d413fb-a3f2-462f-bf87-9984047f317a");
        uuids.add("fec9fdf4-7882-4666-9cf5-ed67359200bb");
        uuids.add("af6d0eb7-4821-4b0f-9ade-7849df28189c");
        uuids.add("19d2bc95-643e-49e3-b462-f86d02c08772");
        uuids.add("cc5ed347-bdd1-4cf5-843a-7de96804c5f2");
        uuids.add("24cc9085-5413-4faf-b3d4-0b336835b3c6");
        uuids.add("88a69859-f684-4ce9-bc7d-636cbdcbe9ea");
        uuids.add("c5940df8-2fba-4a47-b0ed-80d19769d1d1");
        uuids.add("cc06e619-4af5-4768-a354-7b70aa84150f");
        uuids.add("89dc51ff-a54a-4811-a030-e328efcd3b4a");
        uuids.add("0b0103de-dcab-4f9d-8678-c582b6ae27b5");
        uuids.add("ee0a2ee1-89bd-4dd2-a59f-847aae38e8f3");
        uuids.add("e591a4f3-2407-4d6c-b030-e70da926a57b");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        int typeCount = 6;
                        int entryCount = typeCount * 10;

                        Type[] types = new Type[typeCount];

                        for (int i = 0; i < typeCount; i++) {
                            types[i] = createObject(realm, Type.class);
                        }

                        types[0].setValue("kliky");
                        types[1].setValue("drepy");
                        types[2].setValue("zhyby");
                        types[3].setValue("zdvihy nôh");
                        types[4].setValue("mostíky");
                        types[5].setValue("kliky v stojke");

                        Entry[] entries = new Entry[entryCount];

                        for (int i = 0; i < entryCount; i++) {
                            entries[i] = createObject(realm, Entry.class);
                            entries[i].setType(types[i / 10]);
                            entries[i].setLevel((i % 10) + 1);
                        }

                        realm.insert(Arrays.asList(types));
                        realm.insert(Arrays.asList(entries));

                    }
                }).build();

        Realm.setDefaultConfiguration(config);
        Log.d("Realm path: ", config.getPath());
    }

    private <E extends RealmModel> E createObject(Realm realm, Class<E> clazz) {
        return realm.createObject(clazz, getUuid());
    }

    private String getUuid() {
        String uuid = uuids.get(counter);
        counter++;
        return uuid;
    }

}
