package gr.uop;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        //
        //
        //Main scene declarations
        //
        //
        Pane mainp = new Pane();
        BackgroundImage bg = new BackgroundImage(new Image("file:Images/map.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        VBox contentstable = new VBox();
        Button help = new Button("Help");
        Image city = new Image("file:Images/cityt.png");
        Image cityhover = new Image("file:Images/city2.png", 20, 0, false, false);
        ImageView Athens = new ImageView(city);
        ImageView AthensHover = new ImageView(cityhover);
        ImageView Sparta = new ImageView(city);
        ImageView SpartaHover = new ImageView(cityhover);
        ImageView Thebes = new ImageView(city);
        ImageView ThebesHover = new ImageView(cityhover);
        ImageView Pella = new ImageView(city);
        ImageView PellaHover = new ImageView(cityhover);
        ImageView Knossos = new ImageView(city);
        ImageView KnossosHover = new ImageView(cityhover);
        var scene = new Scene(mainp, 750, 657);

        //
        //
        //Secondary scene
        //
        //
        VBox mainps = new VBox();
        GridPane buttons_pane = new GridPane();
        String[] label_contents = {"ATHENS", "SPARTA", "THEBES", "MACEDON", "KNOSSOS"};
        Label[] headers = new Label[5];
        Button back = new Button("Back");
        StackPane labelpane = new StackPane();
        var scene_secondary = new Scene(mainps, 750, 657);
        scene_secondary.getStylesheets().add("file:src/main/java/gr/uop/styles.css");
        StackPane backwrap = new StackPane();
        Image milimg = new Image("file:Images/helmets.png", 250, 0, true, false);
        ImageView milimgview = new ImageView(milimg);
        Button militarybutton = new Button();
        Image culimg = new Image("file:Images/culture.png", 250, 0, true, false);
        ImageView culimgview = new ImageView(culimg);
        Button culturebutton = new Button();
        Image hisimg = new Image("file:Images/history.png", 250, 0, true, false);
        ImageView hisimgview = new ImageView(hisimg);
        Button historybutton = new Button();
        Image polimg = new Image("file:Images/politics.png", 250, 0, true, false);
        ImageView polimgview = new ImageView(polimg);
        Button politicsbutton = new Button();
        StackPane extrabutton = new StackPane();
        Image relimg = new Image("file:Images/religion.png", 250, 0, true, false);
        ImageView relimgview = new ImageView(relimg);
        Button religionbutton = new Button();
        
        //Military button
        militarybutton.setGraphic(milimgview);
        buttons_pane.add(militarybutton, 0, 0);

        //Culture Button
        culturebutton.setGraphic(culimgview);
        buttons_pane.add(culturebutton, 1, 0);

        //History Button
        historybutton.setGraphic(hisimgview);
        buttons_pane.add(historybutton, 0, 1);

        //Politics Button
        politicsbutton.setGraphic(polimgview);
        buttons_pane.add(politicsbutton, 1, 1);

        //Religion Button
        religionbutton.setGraphic(relimgview);
        extrabutton.getChildren().add(religionbutton);
        extrabutton.setAlignment(Pos.CENTER);

        buttons_pane.setPadding(new Insets(100, 10, 20, 10));
        buttons_pane.setHgap(30);
        buttons_pane.setVgap(20);
        buttons_pane.setAlignment(Pos.CENTER);
        extrabutton.setPadding(new Insets(0, 10, 140, 10));
      
        //Initialise labels
        for(int i = 0 ; i < headers.length ; i++)
        {
            headers[i] = new Label(label_contents[i]);
            headers[i].setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 50));
            headers[i].setVisible(false);
        }

        for(int i = 0 ; i < headers.length ; i++)
        {
            labelpane.getChildren().add(headers[i]);
        }
        back.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 20));    
        backwrap.getChildren().add(back);
        backwrap.setAlignment(Pos.BOTTOM_CENTER);
        backwrap.setPadding(new Insets(0, 0, 10, 0));
        mainps.getChildren().addAll(labelpane, buttons_pane, extrabutton, backwrap);


        //
        //
        //Military scene
        //
        //
        VBox milmain = new VBox();
        String milheadercontents[] = {"ATHENIAN MILITARY", "SPARTAN MILITARY", "THEBAN MILITARY", "MACEDONIAN MILITARY", "KNOSSIAN MILITARY"};
        Label milheaders[] = new Label[5];
        StackPane millabelspane = new StackPane();
        var milscene = new Scene(milmain, 750, 657);
        Image milimgs[] = new Image[milheadercontents.length];
        ImageView milimgsview[] = new ImageView[milheadercontents.length];
        StackPane milimgpane = new StackPane();
        ScrollPane mainarticle[] = new ScrollPane[milheaders.length];
        StackPane milarticlespane = new StackPane();
        TextFlow milarticles[] = new TextFlow[milheaders.length];
        Button milback = new Button("Back");
        StackPane milbackwrap = new StackPane();


        milarticles[0] = new TextFlow(new Text("The Athenian military, much like most other militaries of that era, mostly relied on the concept of a Phalanx which was a rectangular military formation that usually consisted entirely of heavy spearmen, known as Hoplites.\n\nIn Athens, there wasn't a standing army of professional troops. Instead, every able-bodied male citizens between the ages of 18 and 60 were expected to serve in times of war. To prepare the citizens for a potential war, all men had to join the army for 2 years, from the age of 18 until the age of 20, during which time they trained and helped guard the city. Each citizen was expected to bring his own equipment, so there was no standard uniform. Infact, the symbols on each Hoplite's shield could be something of their own design or a symbol of their family or clan. Despite the lack of uniformity, every man in the Phalanx was expected to at the very least have a thrusting spear, a sword, some sort of body armour and helmet as well as a shield.\n\nEach Hoplite was accompanied by an attendant, who was usually a slave or another citizen that hadn't inherited any equipment to become a Hoplite and couldn't afford any either. Those attendants carried the Hoplite's shield and luggage during marches and were used as light infantry and long range troops during battles.\n\nHowever, where the Athenian military truly shone, was its Navy. In fact, few if any could claim to be able to match the Athenians at sea, since with their combat prowess and expertise, they were able to defeat even larger fleets. The Athenian Navy consisted of 80,000 crewing 400 ships. The backbone of the navy's manpower was a core of professional rowers drawn from the lower classes of Athenian society. This gave the Athenian fleets an advantage in training over the less professional fleets of its rivals. The main warships of the fleet were the triremes. With its fleet, Athens was able to obtain hegemony over the rest of the Greek city-states. The fleet included two sacred ships, the Paralus and the Salaminia used for diplomatic and ceremonial duties."));
        milarticles[1] = new TextFlow(new Text("The land army of ancient Sparta was perhaps the most well known and feared military force of that time. Infact, many of the other Greek city states considered the Spartan phalanx to be 'invincible', a notion which was later destroyed by the Thebans.\n\nHowever, the reputation of the Spartan hoplites was not unjustified. Unlike most other city states in the region, the Spartan army wasn't a force of barely trained citizens that was assembled only in times of war, but instead a professional fighting force. To achieve this, every Spartan male devoted his life to soldierhood. From the young age of 7 and up until the age of 30 every citizen had to go through a most harsh and brutal military training, known as the 'Agoge', where he would learn how to wrestle and use all sorts of weapons, as well as how to survive in the wild and perform stealthy tasks, mainly practiced through stealing food.\n\nFrom the age of 20 onwards, a Spartan was considered an adult, could vote in the assembly and was eligible for military service. If he had demonstrated sufficient leadership qualities throughout his training, he might be selected to lead an agele. Those who had impressed their elders the most during their training could be selected for the Crypteia, a type of 'Secret Police' tasked with maintaining control over the Helot population through violence as well as perform intelligence, assassinations and sabotage during times of war.\n\nIt wasn't just the training of the Spartan hoplites that made them such a respected force. The Spartans had also made advancements in their tactics when it came to fighting in a Phalanx formation. In contrast to the Phalanxes of most other armies of that era, the Spartan Phalanx was quite more maneuverable and could be separated in smaller units instead of one large solid rectangle to perform combat maneuvers. On top of that, during wartime the large slave population of Sparta, the Helots, were used as light infantry or long range units. "));
        milarticles[2] = new TextFlow(new Text("The Thebans, much like most other city-states of that time did not have a standing professional army, but instead relied on mercenaries and the citizenry to fight in case of war, using the Phalanx formation, a rectangular mass military formation, usually composed entirely of heavy infantry armed with spears.\n\nHowever, there was an exception to this. The Sacred Band of Thebes, an elite military professional formation within the Theban army that consisted of 150 pairs of lovers and whom the Spartans saw as equals in battle. The hard earned respect was not only due to their equipment and training, but also due to the ferocity that they fought with, as the lovers would often find themselves brutally and selflessly fighting to the bitter end to ensure their loved one's survival. Infact, it was largerly thanks to the Sacred Band and their ferocity, coupled with Epaminondas' tactical and strategical genius that the Thebans were able to defeat the Spartan army at the battle of Leuctra, suffering only ten dozen men in casualties of their own while claiming the lives of around one thousand Spartans and helots. It is also worth noting that in this battle, the Thebans were heavily outnumbered by the Spartan forces.\n\nThe Sacred Band of Thebes was later utterly annihilated at the Battle of Chaeronea by Philip the second of Macedon who had introduced the Sarissa spear to the Phalanx, further enhancing the capabilities of the formation. Epaminondas, the brilliant leader who had beaten the Spartans had died around 30 years before the Band was destroyed and Theban hegemony came to an end."));
        milarticles[3] = new TextFlow(new Text("Macedon, for most of its history, employed a normal phalanx formation when it came to its fighting force, along with mercenary units from the North, like the Thracian swordsmen and it was mostly regarded as a second rate power at best. That all changed when Philip the second became king of Macedon.\n\nPhilip had spent much of his childhood in Thebes and had received military and diplomatic training by Epaminondas, who was responsible for defeating the Spartan army at the battle of Leuctra. Under Philip, the Macedonian infantry and cavalry forces were doubled, however it wasn't numbers that turned army of Macedon into a formidable fighting force. Philip also introduced a new weapon for his Phalanx, the Sarissa spear, a 4-6 meter long thrusting spear. These longer spears improved the strength of the phalanx by extending the rows of overlapping weapons projecting towards the enemy and they also kept the Hoplites at a safe distance from their enemies as no melee weapon of the time could reach them. To accommodate for the longer, overlapping spears, a much smaller shield had to be used. This wasn't that huge of a drawback, since the sarissas themselves could be used to deflect enemy arrows when they were raised upwards en masse.\n\nIt was in great part thanks to Philip's innovations that Alexander the Great was able to defeat the Persians and build his empire, yet it would be unfair not to mention the innovations, mainly in the Macedonian army's tactics that he introduced too. Namely, perhaps for one of the first times in history, the Macedonian army perfected coordination of different types of units in an early example of combined arms tactics. The heavy sarissa equiped Hoplites of the Macedonian Phalanx would act as an impenetrable wall against the opposing army, wearing them down and at the same time, light infantry units would attack the exposed flanks of the enemy force, while the Companion cavalry would charge through the enemy rear, spreading chaos and dealing massive casualties. This style of combat proved to be superior to the normal Phalanx or any other military formation of that time.\n\nAfter the death of Alexander the Great, the combined arms approach was rarely ever utilised anymore and eventually the Romans took advantage of that and the Phalanx's lack of maneuverability to defeat it."));
        milarticles[4] = new TextFlow(new Text("Not too much is known about the military forces of Knossos. Much before the era of Classical Greece, back at the end of the Bronze age and before the decline of the Minoan civlization, it can be assumed from paintings on walls that they largely used swords, spears and axes, along with shields as their main armaments, while the nobles and richest citizens could also afford armour made entirely of bronze. For defence, they mainly relied on their fleet to deter or defeat any invading forces before they could land on the island.\n\nDuring the Classical era, it is safe to assume that they mainly used a Phalanx, much like all other Greek city-states.\n\nWhat the Cretans became well known for however was their archers who were widely recognized as being amongst the best light missile troops in the ancient world. Cretan archers carried composite bows, consisting of a wooden core with laminated layers of sinew and horn. These weapons, while difficult to string and use, gave the professional Cretan archers greater range than the simple wooden bows of the citizen levies of mainland Greece. These archers were greatly sought after by other city-states and several units of Cretan archers could be found employed as mercenaries in the Athenian, Macedonian and even Roman armies. Infact, Cretan archers outlived the civilisation they first appeared in and kept on serving in the Roman and Byzantine Empires up until Constantinople fell to the Ottomans."));

        for(int i = 0 ; i < milimgs.length; i++)
        {
            mainarticle[i] = new ScrollPane();
            mainarticle[i].setVisible(false);
            mainarticle[i].setContent(milarticles[i]);
            mainarticle[i].setFitToWidth(true);
            mainarticle[i].setHbarPolicy(ScrollBarPolicy.NEVER);
            mainarticle[i].setPrefHeight(200);
            mainarticle[i].setPadding(new Insets(5, 5, 5, 5));
            milarticlespane.getChildren().add(mainarticle[i]);
        }

        milarticlespane.setPadding(new Insets(25, 5, 25, 5));

        milimgs[0] = new Image("file:Images/AthensPhalanx.png", 400, 250, false, false);
        milimgs[1] = new Image("file:Images/SpartaPhalanx.png", 400, 250, false, false);
        milimgs[2] = new Image("file:Images/ThebesPhalanx.jpg", 400, 250, false, false);
        milimgs[3] = new Image("file:Images/MacedonPhalanx.png", 400, 250, false, false);
        milimgs[4] = new Image("file:Images/CretanArchers.png", 400, 250, false, false);

        for(int i = 0 ; i < milimgs.length; i++)
        {
            milimgsview[i] = new ImageView(milimgs[i]);
        }

        for(int i = 0 ; i < milimgs.length; i++)
        {
            milimgpane.getChildren().add(milimgsview[i]);
            milimgsview[i].setVisible(false);
        }
        milimgpane.setPadding(new Insets(0, 30, 25, 30));

        for(int i = 0 ; i < milheaders.length ; i++)
        {
            milheaders[i] = new Label(milheadercontents[i]);
            milheaders[i].setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 50));
            milheaders[i].setVisible(false);
        }

        for(int i = 0 ; i < headers.length ; i++)
        {
            millabelspane.getChildren().add(milheaders[i]);
        }

        milback.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 20));    
        milbackwrap.getChildren().add(milback);
        milbackwrap.setAlignment(Pos.BOTTOM_CENTER);
        milbackwrap.setPadding(new Insets(0, 0, 10, 0));

        milmain.getChildren().addAll(millabelspane, milimgpane, milarticlespane, milbackwrap);

        //
        //
        //
        //Religion scene
        //
        //
        //
        VBox relmain = new VBox();
        Label relheader = new Label("RELIGION IN ANCIENT GREECE");
        ImageView cotg = new ImageView(new Image("file:Images/CouncilOfTheGods.png", 650, 0, true, false));
        TextFlow reltext = new TextFlow(new Text("Ancient Greek theology was polytheistic, based on the assumption that there were many gods and goddesses, as well as a range of lesser supernatural beings of various types. Most ancient Greeks recognized the twelve major Olympian gods and goddesses—Zeus, Hera, Poseidon, Demeter, Athena, Ares, Aphrodite, Apollo, Artemis, Hephaestus, Hermes, and either Hestia or Dionysus who they believed resided on Mount Olympus.There was a hierarchy of deities, with Zeus, the king of the gods, having a level of control over all the others, although he was not almighty.\n\nSome deities had dominion over certain aspects of nature. For instance, Zeus was the sky-god, sending thunder and lightning, Poseidon ruled over the sea and earthquakes, Hades projected his remarkable power throughout the realms of death and the Underworld, and Helios controlled the sun. Other deities ruled over abstract concepts; for instance Aphrodite controlled love. All significant deities were visualized as \"human\" in form, although often able to transform themselves into animals or natural phenomena.\n\nWhile being immortal, the gods were certainly not all-good or even all-powerful. They had to obey fate, known to Greek mythology as the Moirai, which overrode any of their divine powers or wills. For instance, in mythology, it was Odysseus' fate to return home to Ithaca after the Trojan War, and the gods could only lengthen his journey and make it harder for him, but they could not stop him. The gods acted like humans and had human vices. They would interact with humans, sometimes even spawning children with them. At times certain gods would be opposed to others, and they would try to outdo each other. In the Iliad, Aphrodite, Ares and Apollo support the Trojan side in the Trojan War, while Hera, Athena and Poseidon support the Greeks\n\nWhen it came to an afterlife, the Greeks believed in an underworld where the spirits of the dead went after death. One of the most widespread areas of this underworld was ruled over by Hades, a brother of Zeus, and was itself also known as Hades (originally called 'the place of Hades'). Other well known realms are Tartarus, a place of torment for the damned, and Elysium, a place of pleasures for the virtuous. In the early Mycenaean religion all the dead went to Hades, but the rise of mystery cults in the Archaic age led to the development of places such as Tartarus and Elysium.\n\nA few Greeks, like Achilles, Alcmene, Amphiaraus Ganymede, Ino, Melicertes, Menelaus, Peleus, and a great number of those who fought in the Trojan and Theban wars, were considered to have been physically immortalized and brought to live forever in either Elysium, the Islands of the Blessed, heaven, the ocean, or beneath the ground. Such beliefs are found in the most ancient of Greek sources, such as Homer and Hesiod.\n\nSome Greeks, such as the philosophers Pythagoras and Plato, also embraced the idea of reincarnation, though this was only accepted by a few. Epicurus taught that the soul was simply atoms which were dissolved at death, so one ceased to exist on dying.\n\nGreek religion had an extensive mythology. It consisted largely of stories of the gods and how they interacted with humans. Myths often revolved around heroes and their actions, such as Heracles and his twelve labors, Odysseus and his voyage home, Jason and the quest for the Golden Fleece and Theseus and the Minotaur.\n\nMany species existed in Greek mythology. Chief among these were the gods and humans, though the Titans (who predated the Olympian gods) also frequently appeared in Greek myths. Lesser species included the half-man-half-horse centaurs, the nature based nymphs (tree nymphs were dryads, sea nymphs were Nereids) and the half man, half goat satyrs. Some creatures in Greek mythology were monstrous, such as the one-eyed giant Cyclopes, the sea beast Scylla, whirlpool Charybdis, Gorgons, and the half-man, half-bull Minotaur.\n\nThere was not a set Greek cosmogony, or creation myth. Different religious groups believed that the world had been created in different ways. One Greek creation myth was told in Hesiod's Theogony. It stated that at first there was only a primordial deity called Chaos, who gave birth to various other primordial gods, such as Gaia, Tartarus and Eros, who then gave birth to more gods, the Titans, who then gave birth to the first Olympians.\n\nAncient Greek cities tended to contain temples dedicated to several gods of the Greek pantheon. However, each generally had a primary temple, often on the Acropolis, dedicated to the god that was considered to have a special bond with the city and therefore to be its primary protector.\n\nAthens worshipped Athena, the goddess of wisdom, as a patron city-state god. The designation of Athena as patron of Athens occurred during the Great Panathenaea in 566 B.C.\nSparta worshipped Ares and Artemis Orthia as their patron deities. 3 major festivals of Sparta namely Hyacinthia, Gymnopaedia and Carnea were celebrated in the honor of Apollo. Lycurgus, the lawgiver of Sparta established the military-oriented reformation of Spartan society in accordance with the Oracle of Apollo at Delphi.\nThe patron god of Thebes was Apollo and Dionysus, also called Bacchus and Iacchos. Dionysus' mother, Semele, was a Theban princess. Sophocles includes in his play Antigone an ode to Dionysus, the guardian of Thebes. Because Thebans had close ties with Delphi, Apollo was also the patron god of the city."));
        ScrollPane relmainart = new ScrollPane(reltext);
        Button relback = new Button("Back");
        StackPane relbackwrap = new StackPane();
        StackPane relmainartpane = new StackPane();
        var relscene = new Scene(relmain, 750, 657);

        relmainart.setFitToWidth(true);
        relmainart.setHbarPolicy(ScrollBarPolicy.NEVER);
        relmainart.setPrefHeight(200);
        relheader.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 50));
        relback.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 20)); 
        relbackwrap.getChildren().add(relback);
        relmainart.setPadding(new Insets(5, 5, 5, 5));
        relmainartpane.getChildren().add(relmainart);
        relmainartpane.setPadding(new Insets(25, 5, 25, 5));
        relbackwrap.setPadding(new Insets(0, 0, 20, 0));
        relmain.getChildren().addAll(relheader, cotg, relmainartpane, relbackwrap);
        relmain.setAlignment(Pos.CENTER);

        //Religion button
        religionbutton.setOnAction((e) -> {
            stage.setScene(relscene);
            stage.show();
            relback.setOnAction((event) -> {
                stage.setScene(scene_secondary);
                stage.show();
            });
        });

        //
        //
        //
        //History Scene
        //
        //
        //
        VBox hismain = new VBox();
        String hisheadercontents[] = {"HISTORY OF ATHENS", "HISTORY OF SPARTA", "HISTORY OF THEBES", "HISTORY OF MACEDONIA", "HISTORY OF KNOSSOS"};
        Label hisheaders[] = new Label[5];
        StackPane hislabelspane = new StackPane();
        var hisscene = new Scene(hismain, 750, 657);
        Image hisimgs[] = new Image[hisheadercontents.length];
        ImageView hisimgsview[] = new ImageView[hisheadercontents.length];
        StackPane hisimgpane = new StackPane();
        ScrollPane hismainarticle[] = new ScrollPane[hisheaders.length];
        StackPane hisarticlespane = new StackPane();
        TextFlow hisarticles[] = new TextFlow[hisheaders.length];
        Button hisback = new Button("Back");
        StackPane hisbackwrap = new StackPane();


        hisarticles[0] = new TextFlow(new Text("Athens is one of the oldest named cities in the world, having been continuously inhabited for perhaps 5,000 years. Situated in southern Europe, Athens became the leading city of Ancient Greece in the first millennium BC, and its cultural achievements during the 5th century BC laid the foundations of Western civilization.\n\nAthens has been inhabited from Neolithic times, possibly from the end of the fourth millennium BC, or over 5,000 years. By 1412 BC, the settlement had become an important center of the Mycenaean civilization and the Acropolis was the site of a major Mycenaean fortress whose remains can be recognised from sections of the characteristic Cyclopean walls. On the summit of the Acropolis, below the later Erechtheion, cuttings in the rock have been identified as the location of a Mycenaean palace.\n\nFrom 900 BC onwards Athens was one of the leading centres of trade and prosperity in the region. This position may well have resulted from its central location in the Greek world, its secure stronghold on the Acropolis and its access to the sea, which gave it a natural advantage over inland rivals such as Thebes and Sparta.\n\nAccording to legend, Athens was formerly ruled by kings, a situation which may have continued up until the 9th century BC. From later accounts, it is believed that these kings stood at the head of a land-owning aristocracy known as the Eupatridae (the 'well-born'), whose instrument of government was a Council which met on the Hill of Ares, called the Areopagus and appointed the chief city officials, the archons and the polemarch (commander-in-chief). The most famous king of Athens was Theseus, a prominent figure in Greek Mythology who was the one who killed the Minotaur.\n\nDuring this period, Athens succeeded in bringing the other towns of Attica under its rule. This process of synoikismos – the bringing together into one home – created the largest and wealthiest state on the Greek mainland, but it also created a larger class of people excluded from political life by the nobility. By the 7th century BC, social unrest had become widespread, and the Areopagus appointed Draco to draft a strict new code of law (hence the word 'draconian'). When this failed, they appointed Solon, with a mandate to create a new constitution (in 594 BC).\n\nThe reforms that Solon initiated dealt with both political and economic issues. The economic power of the Eupatridae was reduced by forbidding the enslavement of Athenian citizens as a punishment for debt (debt bondage), by breaking up large landed estates and freeing up trade and commerce, which allowed the emergence of a prosperous urban trading class. Politically, Solon divided the Athenians into four classes, based on their wealth and their ability to perform military service. The poorest class, the Thetai, (Ancient Greek Θήται) who formed the majority of the population, received political rights for the first time and were able to vote in the Ecclesia (Assembly). But only the upper classes could hold political office. The Areopagus continued to exist but its powers were reduced. The new system laid the foundations for what eventually became Athenian democracy, but in the short-term it failed to quell class conflict and after twenty years of unrest the popular party, led by Peisistratus, seized power (in 541 BC).\n\nPeisistratus died in 527 BC and was succeeded by his sons Hippias and Hipparchus. They proved to be much less adept rulers and in 514 BC, Hipparchus was assassinated in a private dispute. This led Hippias to establish a real dictatorship, which proved very unpopular. He was overthrown in 510 BC. A radical politician with an aristocratic background named Cleisthenes then took charge, and it was he who established democracy in Athens. The reforms of Cleisthenes replaced the traditional four phyle ('tribes') with ten new ones, named after legendary heroes and having no class basis; they were in fact electorates. Each phyle was in turn divided into three trittyes and each trittys had one or more demes, which became the basis of local government. The phyle each elected fifty members to the Boule, a council which governed Athens on a day-to-day basis. The Assembly was open to all citizens and was both a legislature and a supreme court, except in murder cases and religious matters, which became the only remaining functions of the Areopagus.\n\nPrior to the rise of Athens, Sparta considered itself to be the leader (or hegemon) of the Greeks. In 499 BC, Athens sent troops to aid the Ionian Greeks of Asia Minor, who were rebelling against the Persian Empire (the Ionian Revolt). This provoked two Persian invasions of Greece by the Achaemenid Empire. In 490 BC, the Athenians, led by the soldier-statesman Miltiades, defeated the first invasion of the Persians under Darius I at the Battle of Marathon.In 480 BC, the Persians returned under Darius's son Xerxes. When a small Greek force holding the pass of Thermopylae was defeated, the Persians proceeded to capture an evacuated Athens. The city of Athens was twice captured and sacked by the Persians within one year after Thermopylae. Subsequently, the Athenians (led by Themistocles), with their allies, engaged the much larger Persian navy at sea in the Battle of Salamis and routed the Persians, a great turning point in the war. In 479 BC, the Athenians and Spartans, with their allies, defeated the Persian army conclusively at the Battle of Plataea. Athens then took the war to Asia Minor. These victories enabled it to bring most of the Aegean and many other parts of Greece together in the Delian League, an Athenian-dominated alliance.\n\nThe resentment felt by other cities at the hegemony of Athens led to the Peloponnesian War, which began in 431 BC and pitted Athens and its increasingly rebellious overseas empire against a coalition of land-based states led by Sparta. The conflict was a drawn out one that saw Sparta control the land while Athens was dominant at sea, however the disastrous Sicilian Expedition severely weakened Athens and the war eventually ended in an Athenian defeat following the Battle of Aegospotami which ended Athenian naval supremacy. The Peloponnesian War ended in 404 BC with the complete defeat of Athens. Since the loss of the war was largely blamed on democratic politicians such as Cleon and Cleophon, there was a brief reaction against democracy, aided by the Spartan army (the rule of the Thirty Tyrants). In 403 BC, however, democracy was restored by Thrasybulus and an amnesty was declared.\n\nSparta's former allies soon turned against her, due to her imperialist policy, and soon Athens' former enemies Thebes and Corinth had become her allies; they fought with Athens and Argos against Sparta in the indecisive Corinthian War (395 – 387 BC). Opposition to Sparta enabled Athens to establish a Second Athenian League. Finally Thebes defeated Sparta in 371 BC in the Battle of Leuctra.\n\nBy the mid-4th century BC, however, the northern Greek kingdom of Macedon was becoming dominant in Athenian affairs. In the Battle of Chaeronea (338 BC), Philip II's armies defeated an alliance of some of the Greek city-states including Athens and Thebes, forcing them into a confederation and effectively limiting Athenian independence. Philippides of Paiania, one of the wealthiest Athenian aristocratic oligarchs, campaigned for Philip II during the Battle of Chaeronea and proposed in the Assembly decrees honoring Alexander the Great for the Macedonian victory. Philippides was prosecuted in trial by Hypereides, who detested his pro-Macedonian sympathies. Subsequently, the conquests of Alexander the Great widened Greek horizons and made the traditional Greek city state obsolete. Athens remained a wealthy city with a brilliant cultural life, but ceased to be a leading power. The period following the death of Alexander in 323 BC is known as Hellenistic Greece."));
        hisarticles[1] = new TextFlow(new Text("The earliest certain evidence of human settlement in the region of Sparta, consists of pottery dating from the Middle Neolithic period found in the vicinity of Kouphovouno some two kilometres southwest of Sparta.\n\nAccording to myth, the first king of the region later to be called Laconia, but then called Lelegia was the eponymous King Lelex. He was followed, according to tradition, by a series of kings allegorizing several traits of later-to-be Sparta and Laconia, such as the Kings Myles, Eurotas, Lacedaemon and Amyclas of Sparta. The last king from their family was Tyndareus, father of Castor and Clytemnestra and foster-father to Pollux and Helen of Troy. Later the Achaeans, associated with Mycenaean Greece, immigrated from the north and replaced the Lelegians as ruling tribe. The Pre-Dorian, supposedly Mycenaean, civilization seems to have fallen into decline by the late Bronze Age, when, according to Herodotus, Macedonian tribes from the north marched into Peloponnese, where they were called Dorians and subjugating the local tribes, settled there.\n\nArcheologically, Sparta itself begins to show signs of settlement only around 1000 BC, some 200 years after the collapse of Mycenaean civilization.  The four villages that made up the Spartan Polis, George Forrest suggests that the two closest to the Acropolis were the originals, and the two more far-flung settlements were of later foundation. One of the effects of the Mycenaean collapse had been a sharp drop in population. Following that, there was a significant recovery, and this growth in population is likely to have been more marked in Sparta, as it was situated in the most fertile part of the plain. Between the 8th and 7th centuries BC the Spartans experienced a period of lawlessness and civil strife, later testified by both Herodotus and Thucydides. As a result, they carried out a series of political and social reforms of their own society which they later attributed to a semi-mythical lawgiver, Lycurgus. These reforms mark the beginning of the history of Classical Sparta.\n\nIt is during the reign of King Charillos, that most ancient sources place the life of Lycurgus. Indeed, the Spartans ascribed their subsequent success to Lycurgus, who instituted his reforms at a time when Sparta was weakened by internal dissent and lacked the stability of a united and well-organized community. J. F. Lazenby suggests, that the dual monarchy may date from this period as a result of a fusion of the four villages of Sparta which had, up until then, formed two factions of the villages of Pitana-Mesoa against the villages of Limnai-Konoura. According to this view, the Kings, who tradition says ruled before this time, were either totally mythical or at best factional chieftains.\n\nTyrtaeus tells that the war to conquer the Messenians, their neighbors on the west, led by Theopompus, lasted 19 years and was fought in the time of the fathers of our fathers. If this phrase is to be taken literally, it would mean that the war occurred around the end of the 8th century BC or the beginning of the 7th. The historicity of the Second Messenian War was long doubted, as neither Herodotus or Thucydides mentions a second war. However, in the opinion of Kennell, a fragment of Tyrtaeus (published in 1990) gives us some confidence that it really occurred (probably in the later 7th century). It was as a result of this second war, according to fairly late sources, that the Messenians were reduced to the semi slave status of helots. In the Second Messenian War, Sparta established itself as a local power in Peloponnesus and the rest of Greece. During the following centuries, Sparta's reputation as a land-fighting force was unequaled. By the 6th century, through a series of conquests in Peloponnesus, Sparta had come to be acknowledged as the leading state of Hellas and the champion of Hellenism. Croesus of Lydia had formed an alliance with it. Scythian envoys sought its aid to stem the invasion of Darius; to Sparta, the Greeks of Asia Minor appealed to withstand the Persian advance and to aid the Ionian Revolt; Plataea asked for Sparta's protection; Megara acknowledged its supremacy; and at the time of the Persian invasion under Xerxes no state questioned Sparta's right to lead the Greek forces on land or at sea.\n\nLater on, at the time of the Persian invasion, after hearing a plea for help from Athens who were facing the Persians at Marathon in 490 BC, Sparta decided to honor its laws and wait until the moon was full to send an army. As a result, Sparta's army arrived at Marathon after the battle had been won by the Athenians.\n\nIn the second campaign, conducted ten years later by Xerxes, Sparta faced the same dilemma. The Persians inconveniently chose to attack during the Olympic truce which the Spartans felt they must honor. Other Greek states which lacked such scruples were making a major effort to assemble a fleet – how could Sparta not contribute on land when others were doing so much on sea? The solution was to provide a small force under Leonidas to defend Thermopylae. However, there are indications that Sparta's religious scruples were merely a cover. From this interpretation, Sparta believed that the defense of Thermopylae was hopeless and wished to make a stand at the Isthmus, but they had to go through the motions or Athens might ally itself with Persia. The loss of Athens's fleet would simply be too great a loss to the Greek resistance to be risked. The alternative view is that, on the evidence of the actual fighting, the pass was supremely defensible, and that the Spartans might reasonably have expected that the forces sent, would be adequate.\n\nIn 480 BC, a small force of Spartans, Thespians, and Thebans led by King Leonidas (approximately 300 were full Spartiates, 700 were Thespians, and 400 were Thebans; these numbers do not reflect casualties incurred prior to the final battle), made a legendary last stand at the Battle of Thermopylae against the massive Persian army, inflicting very high casualties on the Persian forces before finally being encircled. From then on Sparta took a more active share and assumed the command of the combined Greek forces by sea and land. The decisive victory of Salamis did not change Sparta's essential dilemma. Ideally, they would wish to fight at the Isthmus where they would avoid the risk of their infantry being caught in the open by the Persian cavalry.\n\nHowever, in 479 BC, the remaining Persian forces under Mardonius devastated Attica, Athenian pressure forced Sparta to lead an advance. The outcome was a standoff where both the Persians and the Greeks attempted to fight on favorable terrain, and this was resolved when the Persians attacked during a botched Greek withdrawal. In the resulting Battle of Plataea the Greeks under the generalship of the Spartan Pausanias overthrew the lightly armed Persian infantry, killing Mardonius. The superior weaponry, strategy, and bronze armour of the Greek hoplites and their phalanx had proved their worth with Sparta assembled at full strength and leading a Greek alliance against the Persians. The decisive Greek victory at Plataea put an end to the Greco-Persian War along with Persian ambition of expanding into Europe. Even though this war was won by a pan-Greek army, credit was given to Sparta, who besides being the protagonist at Thermopylae and Plataea, had been the de facto leader of the entire Greek expedition.\n\nThe Sparta earthquake of 464 BC destroyed much of Sparta. Historical sources suggest that the death toll may have been as high as 20,000, although modern scholars suggest that this figure is likely an exaggeration. The earthquake sparked a revolt of the helots, the slave class of Spartan society. Events surrounding this revolt led to an increase in tension between Sparta and their rival Athens and the cancellation of a treaty between them. After the troops of a relief expedition dispatched by conservative Athenians were sent back with cold thanks, Athenian democracy itself fell into the hands of reformers and moved toward a more populist and anti-Spartan policy. Therefore, this earthquake is cited by historical sources as one of the key events that led up to the First Peloponnesian War.\n\nThe Peloponnesian Wars were the protracted armed conflicts, waged on sea and land, of the last half of the 5th century BC between the Delian League controlled by Athens and the Peloponnesian League dominated by Sparta over control of the other Greek city-states. The Delian League is often called \"the Athenian Empire\" by scholars. The Peloponnesian League believed it was defending itself against Athenian aggrandizement. The war had ethnic overtones that generally but not always applied: the Delian League included populations of Athenians and Ionians while the Peloponnesian League was mainly of Dorians, except that a third power, the Boeotians, had sided tentatively with the Peloponnesian League. They were never fully trusted by the Spartans. Ethnic animosity was fueled by the forced incorporation of small Dorian states into the Delian League, who appealed to Sparta. Motivations, however, were complex, including local politics and considerations of wealth. In the end Sparta won, but it declined soon enough and was soon embroiled with wars with Boeotia and Persia.\n\nDuring the Corinthian War Sparta faced a coalition of the leading Greek states: Thebes, Athens, Corinth, and Argos. The alliance was initially backed by Persia, whose lands in Anatolia had been invaded by Sparta and which feared further Spartan expansion into Asia. Sparta achieved a series of land victories, but many of her ships were destroyed at the battle of Cnidus by a Greek-Phoenician mercenary fleet that Persia had provided to Athens.\n\nIn 382 BC, Phoebidas, while leading a Spartan army north against Olynthus made a detour to Thebes and seized the Kadmeia, the citadel of Thebes. It was the seizure of the Kadmeia that led to Theban rebellion and hence to the outbreak of the Boeotian War. In 371 BC, a fresh peace congress was summoned at Sparta to ratify the Peace of Callias. Again the Thebans refused to renounce their Boeotian hegemony, and the Spartan's sent a force under King Cleombrotus in an attempt to enforce Theban acceptance. When the Thebans gave battle at Leuctra, it was more out of brave despair than hope. However, it was Sparta that was defeated and this, along with the death of King Cleombrotus dealt a crushing blow to Spartan military prestige. The result of the battle was to transfer supremacy from Sparta to Thebes.\n\nSparta never fully recovered from the losses that it suffered at Leuctra in 371 BC and the subsequent helot revolts. Nonetheless, it was able to continue as a regional power for over two centuries. Neither Philip II nor his son Alexander the Great attempted to conquer Sparta itself. Eventually, much like the rest of the Ancient Greek city states, Sparta came under Roman control and become a free city in the Roman sense, some of the institutions of Lycurgus were restored."));
        hisarticles[2] = new TextFlow(new Text("Archaeological excavations in and around Thebes have revealed cist graves dated to Mycenaean times containing weapons, ivory, and tablets written in Linear B. It seems safeto infer that Thebes was one of the first Greek communities to be drawn together within a fortified city, and that it owed its importance in prehistoric days — as later — to its military strength. Deger-Jalkotzy claimed that the statue base from Kom el-Hetan in Amenhotep III's kingdom (LHIIIA:1) mentions a name similar to Thebes, spelled out quasi-syllabically in hieroglyphs as d-q-e-i-s, and considered to be one of four Danaan kingdoms worthy of note (alongside Knossos and Mycenae).As a fortified community, it attracted attention from the invading Dorians, and the fact of their eventual conquest of Thebes lies behind the stories of the successive legendary attacks on that city.\n\nThe central position and military security of the city naturally tended to raise it to a commanding position among the Boeotians, and from early days its inhabitants endeavoured to establish a complete supremacy over their kinsmen in the outlying towns. This centralizing policy is as much the cardinal fact of Theban history as the counteracting effort of the smaller towns to resist absorption forms the main chapter of the story of Boeotia. No details of the earlier history of Thebes have been preserved, except that it was governed by a land-holding aristocracy who safeguarded their integrity by rigid statutes about the ownership of property and its transmission over time.\n\nIn the late 6th century BC, the Thebans were brought for the first time into hostile contact with the Athenians, who helped the small village of Plataea to maintain its independence against them, and in 506 BC repelled an inroad into Attica. The aversion to Athens best serves to explain the apparently unpatriotic attitude which Thebes displayed during the Persian invasion of Greece (480–479 BC). Though a contingent of 400 was sent to Thermopylae and remained there with Leonidas before being defeated alongside the Spartans, the governing aristocracy soon after joined King Xerxes I of Persia with great readiness and fought zealously on his behalf at the Battle of Plataea in 479 BC. The victorious Greeks subsequently punished Thebes by depriving it of the presidency of the Boeotian League and an attempt by the Spartans to expel it from the Delphic amphictyony was only frustrated by the intercession of Athens.\n\nIn 457 BC Sparta, needing a counterpoise against Athens in central Greece, reversed her policy and reinstated Thebes as the dominant power in Boeotia. In 424 BC, at the head of the Boeotian levy, they inflicted a severe defeat on an invading force of Athenians at the Battle of Delium, and for the first time displayed the effects of that firm military organization that eventually raised them to predominant power in Greece.\n\nAfter the downfall of Athens at the end of the Peloponnesian War, the Thebans, having learned that Sparta intended to protect the states that Thebes desired to annex, broke off the alliance. In 404 BC, they had urged the complete destruction of Athens; yet, in 403 BC, they secretly supported the restoration of its democracy in order to find in it a counterpoise against Sparta. A few years later, influenced perhaps in part by Persian gold, they formed the nucleus of the league against Sparta. At the Battle of Haliartus (395 BC) and the Battle of Coronea (394 BC), they again proved their rising military capacity by standing their ground against the Spartans. The result of the war was especially disastrous to Thebes, as the general settlement of 387 BC stipulated the complete autonomy of all Greek towns and so withdrew the other Boeotians from its political control. Its power was further curtailed in 382 BC, when a Spartan force occupied the citadel by a treacherous coup-de-main. Three years later, the Spartan garrison was expelled and a democratic constitution was set up in place of the traditional oligarchy. In the consequent wars with Sparta, the Theban army, trained and led by Epaminondas and Pelopidas, proved itself formidable. Years of desultory fighting, in which Thebes established its control over all Boeotia, culminated in 371 BC in a remarkable victory over the Spartans at Leuctra. The winners were hailed throughout Greece as champions of the oppressed. They carried their arms into Peloponnesus and at the head of a large coalition, permanently crippled the power of Sparta, in part by freeing many helot slaves, the basis of the Spartan economy. Similar expeditions were sent to Thessaly and Macedon to regulate the affairs of those regions.\n\nHowever, the predominance of Thebes was short-lived, as the states that it protected refused to subject themselves permanently to its control. Thebes renewed rivalry with Athens, who had joined with them in 395 BC in fear of Sparta, but since 387 BC had endeavoured to maintain the balance of power against its ally, prevented the formation of a Theban empire. With the death of Epaminondas at the Battle of Mantinea (362 BC), the city sank again to the position of a secondary power.\n\nEventually, an unsuccessful revolt in 335 BC against his son Alexander the Great while he was campaigning in the north was punished by Alexander and his Greek allies with the destruction of the city (except, according to tradition, the house of the poet Pindar and the temples), and its territory divided between the other Boeotian cities. Moreover, the Thebans themselves were sold into slavery. Alexander spared only priests, leaders of the pro-Macedonian party and descendants of Pindar."));
        hisarticles[3] = new TextFlow(new Text("The Greek historians Herodotus and Thucydides reported the legend that the Macedonian kings of the Argead dynasty were descendants of Temenus of Argos, Peloponnese, who was believed to have had the mythical Heracles as one of his ancestors. Very little is known about the first five kings of Macedonia (or the first eight kings depending on which royal chronology is accepted). There is much greater evidence for the reigns of Amyntas I of Macedon (r. 547 – 498 BC) and his successor Alexander I, especially due to the aid given by the latter to the Persian commander Mardonius at the Battle of Platea in 479 BC, during the Greco-Persian Wars. Although stating that the first several kings listed by Herodotus were most likely legendary figures, historian Robert Malcolm Errington uses the rough estimate of twenty-five years for the reign of each of these kings to assume that the capital Aigai (modern Vergina) could have been under their rule since roughly the mid-7th century BC, during the Archaic period.\n\nAround the time of Alexander I, the Argead Macedonians started to expand into Upper Macedonia.To the north of Macedonia lay various non-Greek peoples such as the Paeonians due north, the Thracians to the northeast, and the Illyrians, with whom the Macedonians were frequently in conflict, to the northwest. To the south lay Thessaly, with whose inhabitants the Macedonians had much in common, both culturally and politically, while to the west lay Epirus, with whom the Macedonians had a peaceful relationship and in the 4th century BC formed an alliance against Illyrian raids. Prior to the 4th century BC, the kingdom covered a region approximately corresponding to the western and central parts of the region of Macedonia in modern Greece.\n\nIn 512/511 BC Megabazus sent envoys demanding Macedonian submission as a vassal state to the Achaemenid Empire of ancient Persia, to which Amyntas I responded by formally accepting the hegemony of the Persian king of kings. This began the period of Achaemenid Macedonia, which lasted for roughly three decades. The Macedonian kingdom was largely autonomous and outside of Persian control, but was expected to provide troops and provisions for the Achaemenid army. The Macedonians provided military aid to Xerxes I during the Second Persian invasion of Greece in 480–479 BC, which saw Macedonians and Persians fighting against a Greek coalition led by Athens and Sparta. Following the Greek victory at Salamis, the Persians sent Alexander I as an envoy to Athens, hoping to strike an alliance with their erstwhile foe, yet his diplomatic mission was rebuffed. Achaemenid control over Macedonia ceased when the Persians were ultimately defeated by the Greeks and fled the Greek mainland in Europe. Alexander I, who Herodotus claimed was entitled proxenos and euergetes ('benefactor') by the Athenians, cultivated a close relationship with the Greeks following the Persian defeat and withdrawal, sponsoring the erection of statues at both major panhellenic sanctuaries at Delphi and Olympia.\n\nPhilip II of Macedon (r. 359 – 336 BC), who spent much of his adolescence as a political hostage in Thebes, was twenty-four years old when he acceded to the throne and immediately faced crises that threatened to topple his leadership. However, with the use of deft diplomacy, he was able to convince the Athenians to halt their backing of another pretender named Arg(a)eus and was also able to make peace with the Illyrians who had threatened his borders. The exact date in which Philip II initiated reforms to radically transform the Macedonian army's organization, equipment, and training is unknown, including the formation of the Macedonian phalanx armed with long pikes (i.e. the sarissa). The reforms took place over a period of several years and proved immediately successful against his Illyrian and Paeonian enemies.\n\nWhile Athens was preoccupied with the Social War (357–355 BC), Philip took this opportunity to retake Amphipolis in 357 BC, for which the Athenians later declared war on him, and by 356 BC, recaptured Pydna and Potidaea, the latter of which he handed over to the Chalcidian League as promised in a treaty of 357/356 BC. For the next few years Philip II was occupied with reorganizing the administrative system of Thessaly. After the Macedonian victory at Chaeronea, Philip II imposed harsh conditions on Thebes, installing an oligarchy there, yet was lenient to Athens due to his desire to utilize their navy in a planned invasion of the Achaemenid Empire. He was then chiefly responsible for the formation of the League of Corinth that included the major Greek city-states minus Sparta, being elected as the leader (hegemon) of its council (synedrion) by the spring of 337 BC despite the Kingdom of Macedonia being excluded as an official member of the league. The Panhellenic fear of another Persian invasion of Greece perhaps contributed to Philip II's decision to invade the Achaemenid Empire. Before he could however perform his invasion, he was assassinated by his bodyguard as a result of an internal struggle with his son, Alexander. Following Philip's death, the members of the League of Corinth revolted, yet were soon quelled by military force alongside persuasive diplomacy, Alexander forcing them to rejoin the league and elect him as hegemon to carry out the planned invasion of Achaemenid Persia.\n\nIn 335 BC, Alexander led a campaign against the Thracian tribe of the Triballi at Haemus Mons, fighting them along the Danube and forcing their surrender on Peuce Island. Shortly thereafter, the Illyrian king Cleitus of the Dardani threatened to attack Macedonia, yet Alexander took the initiative and besieged them at Pelion (in modern Albania). When Alexander was given news that Thebes had once again revolted from the League of Corinth and were besieging the Macedonian garrison in the Cadmea, Alexander left the Illyrian front and marched to Thebes, which he placed under siege. After breaching the walls, Alexander's forces killed 6,000 Thebans, took 30,000 inhabitants as prisoners of war, and burned the city to the ground as a warning to others.\n\nThroughout his military career and kingship, Alexander won every battle that he personally commanded. His first victory against the Persians in Asia Minor at the Battle of the Granicus in 334 BC utilized a small cavalry contingent that successfully distracted the Persians, allowed his infantry to cross the river, and his Companions to drive them from the battle with a cavalry charge. Darius III, despite having superior numbers, was again forced to flee the Battle of Gaugamela in 331 BC. The Persian king was later captured and executed by his own satrap of Bactria and kinsman, Bessus, in 330 BC. The Macedonian king subsequently hunted down and executed Bessus in what is now Afghanistan, securing the region of Sogdia in the process.\n\nAlexander the Great died at Babylon in 323 BC and his death led to the Partition of Babylon by his former generals, the diadochi, chief among them being Antipater, regent of Alexander IV of Macedon (r. 323 – 309 BC). This event ushered in the Hellenistic period in West Asia and the Mediterranean world, leading to the formation of the Ptolemaic, Seleucid, and Attalid successor kingdoms in the former territories of Alexander's empire.Macedonia continued its role as the dominant state of Hellenistic Greece, yet its authority became diminished due to civil wars between the Antipatrid and nascent Antigonid dynasty. Macedonian attempts to project their power into the Adriatic Sea and formation of a Macedonian–Carthaginian Treaty with Hannibal alarmed the Roman Republic, which convinced a coalition of Greek city-states to attack Macedonia while Rome focused on defeating Hannibal in Italy.\n\nRome was ultimately victorious in the First (214–205 BC) and Second Macedonian War (200–197 BC) against Philip V, who was also defeated in the Cretan War (205–200 BC) by a coalition led by Rhodes. Macedonia was forced to relinquish its holdings in Greece outside of Macedonia proper, while the Third Macedonian War (171–168 BC) succeeded in toppling the monarchy altogether, after which Rome placed Perseus of Macedon (r. 179 – 168 BC) under house arrest and established four client state republics in Macedonia. In an attempt to dissuade rebellion in Macedonia, Rome imposed stringent constitutions in these states that limited their economic growth and interactivity."));
        hisarticles[4] = new TextFlow(new Text("The site of Knossos has had a very long history of human habitation beginning with the founding of the first Neolithic settlement (c. 7000 BCE). Neolithic remains are prolific in Crete. They are found in caves, rock shelters, houses, and settlements. Knossos has a thick Neolithic layer indicating the site was a sequence of settlements before the Palace Period. Arthur Evans, who unearthed the palace of Knossos in modern times, estimated that c. 8000 BCE a Neolithic people arrived at the hill, probably from overseas by boat, and placed the first of a succession of wattle and daub villages (modern radiocarbon dates have raised the estimate to c. 7000–6500 BCE). Large numbers of clay and stone incised spools and whorls attest to local cloth-making. There are fine ground axe and mace heads of colored stone: greenstone, serpentine, diorite and jadeite, as well as obsidian knives and arrowheads along with the cores from which they were flaked. Most significant among the other small items were a large number of animal and human figurines, including nude sitting or standing females with exaggerated breasts and buttocks. Evans attributed them to the worship of the Neolithic mother goddess and figurines in general to religion.\n\nIn the Early Neolithic (6000–5000 BCE), a village of 200–600 persons occupied most of the area of the palace and the slopes to the north and west. They lived in one- or two-room square houses of mud-brick walls set on socles of stone, either field stone or recycled stone artifacts. The inner walls were lined with mud-plaster. The roofs were flat, composed of mud over branches. The residents dug hearths at various locations in the center of the main room. This village had an unusual feature: one house under the West Court contained eight rooms and covered 50 m2 (540 sq ft). The walls were at right angles. The door was centered. Large stones were used for support under points of greater stress. The fact that distinct sleeping cubicles for individuals was not the custom suggests storage units of some sort.\n\nThe settlement of the Middle Neolithic (5000–4000 BCE), housed 500–1000 people in more substantial and presumably more family-private homes. Construction was the same, except the windows and doors were timbered, a fixed, raised hearth occupied the center of the main room, and pilasters and other raised features (cabinets, beds) occupied the perimeter. Under the palace was the Great House, a 100 m2 (1,100 sq ft) area stone house divided into five rooms with meter-thick walls suggesting a second story was present. The presence of the house, which is unlikely to have been a private residence like the others, suggests a communal or public use; i.e., it may have been the predecessor of a palace. In the Late or Final Neolithic (two different but overlapping classification systems, around 4000–3000 BCE), the population increased dramatically.\n\nIt is believed that the first Cretan palaces were built soon after c. 2000 BC, in the early part of the Middle Minoan period, at Knossos and other sites including Mallia, Phaestos and Zakro. These palaces, which were to set the pattern of organisation in Crete and Greece through the second millennium, were a sharp break from the Neolithic village system that had prevailed thus far. The building of the palaces implies greater wealth and a concentration of authority, both political and religious. It is suggested that they followed eastern models such as those at Ugarit on the Syrian coast and Mari on the upper Euphrates.  The early palaces were destroyed during, sometime before c. 1700, almost certainly by earthquakes to which Crete is prone. By c. 1650, they had been rebuilt on a grander scale and the period of the second palaces (c. 1650–c. 1450) marks the height of Minoan prosperity. All the palaces had large central courtyards which may have been used for public ceremonies and spectacles. Living quarters, storage rooms and administrative centres were positioned around the court and there were also working quarters for skilled craftsmen.\n\nThe prosperity of Knossos was primarily based upon the development of native Cretan resources such as oil, wine, and wool. Another factor was the expansion of trade. Herodotus wrote that Minos, the legendary king of Knossos, established a thalassocracy (sea empire). Thucydides accepted the tradition and added that Minos cleared the sea of pirates, increased the flow of trade and colonised many Aegean islands. Archaeological evidence supports the tradition because Minoan pottery is widespread, having been found in Egypt, Syria, Anatolia, Rhodes, the Cyclades, Sicily, and mainland Greece. There seem to have been strong Minoan connections with Rhodes, Miletus, and Samos. Cretan influence may be seen in the earliest scripts found in Cyprus. The main market for Cretan wares was the Cyclades where there was a demand for pottery, especially the stone vases. It is not known whether the islands were subject to Crete or just trading partners, but there certainly was strong Cretan influence. This also applies to the mainland, because both tradition and archaeology indicate strong links between Crete and Athens. The main legend here is the Minotaur story wherein Athens was subject to Knossos and paying tribute. The legend concerns a creature living in a labyrinth who was half-man and half-bull. Bulls are frequently featured on pottery and frescoes found at Knossos, where the intricate layout of the palace might suggest a labyrinth. One of the most common cult-symbols, often seen on palace walls, is the double-headed axe called the labrys, which is a Carian word for that type of tool or weapon.\n\nAt the height of Cretan power around 1450 BC, the palaces at Mallia, Phaestus, and Zakro were destroyed along with smaller settlements elsewhere. Only Knossos remained and it survived until c. 1370. At the time of its destruction, it was occupied by Greeks, whose presence is suggested by a new emphasis on weapons and warfare in both art and burial. Mycenaean-style chamber tombs had been adopted and there was mainland influence on pottery styles.\n\nAfter the fall of the Minoans, Knossus was repopulated approximately 1000 BC and it remained one of the most important centers of Crete. The city had two ports: Amnisos and Heraklion. According to the ancient geographer Strabo the Knossians colonized the city of Brundisium in Italy. In 343 BC, Knossos was allied with Philip II of Macedon. The city employed a Phocian mercenary named Phalaikos against their enemy, the city of Lyttus. The Lyttians appealed to the Spartans who sent their king Archidamus III against the Knossians. In Hellenistic times Knossos came under Egyptian influence, but despite considerable military efforts during the Chremonidean War (267–261 BC), the Ptolemies were not able to unify the warring city states. In the third century BC Knossos expanded its power to dominate almost the entire island, but during the Lyttian War in 220 BC it was checked by a coalition led by the Polyrrhenians and the Macedonian king Philip V. Twenty years later, during the Cretan War (205–200 BC), the Knossians were once more among Philip's opponents and, through Roman and Rhodian aid, this time they managed to liberate Crete from the Macedonian influence. With Roman aid, Knossus became once more the first city of Crete, but, in 67 BC, the Roman Senate chose Gortys as the capital of the newly created province Creta et Cyrene."));

        for(int i = 0 ; i < hisimgs.length; i++)
        {
            hismainarticle[i] = new ScrollPane();
            hismainarticle[i].setVisible(false);
            hismainarticle[i].setContent(hisarticles[i]);
            hismainarticle[i].setFitToWidth(true);
            hismainarticle[i].setHbarPolicy(ScrollBarPolicy.NEVER);
            hismainarticle[i].setPrefHeight(200);
            hismainarticle[i].setPadding(new Insets(5, 5, 5, 5));
            hisarticlespane.getChildren().add(hismainarticle[i]);
        }

        hisarticlespane.setPadding(new Insets(25, 5, 25, 5));

        hisimgs[0] = new Image("file:Images/Acropolis.jpg", 400, 250, false, false);
        hisimgs[1] = new Image("file:Images/SiegeOfSparta.jpg", 400, 250, false, false);
        hisimgs[2] = new Image("file:Images/CadmeaThebes.jpg", 400, 250, false, false);
        hisimgs[3] = new Image("file:Images/AlexanderTheGreat.jpg", 400, 250, false, false);
        hisimgs[4] = new Image("file:Images/KnossosPalace.png", 400, 250, false, false);

        for(int i = 0 ; i < hisimgs.length; i++)
        {
            hisimgsview[i] = new ImageView(hisimgs[i]);
        }

        for(int i = 0 ; i < hisimgs.length; i++)
        {
            hisimgpane.getChildren().add(hisimgsview[i]);
            hisimgsview[i].setVisible(false);
        }
        hisimgpane.setPadding(new Insets(0, 30, 25, 30));

        for(int i = 0 ; i < hisheaders.length ; i++)
        {
            hisheaders[i] = new Label(hisheadercontents[i]);
            hisheaders[i].setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 50));
            hisheaders[i].setVisible(false);
        }

        for(int i = 0 ; i < headers.length ; i++)
        {
            hislabelspane.getChildren().add(hisheaders[i]);
        }

        hisback.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 20));    
        hisbackwrap.getChildren().add(hisback);
        hisbackwrap.setAlignment(Pos.BOTTOM_CENTER);
        hisbackwrap.setPadding(new Insets(0, 0, 10, 0));

        hismain.getChildren().addAll(hislabelspane, hisimgpane, hisarticlespane, hisbackwrap);

        //
        //
        //
        //Politics Scene
        //
        //
        //
        VBox polmain = new VBox();
        String polheadercontents[] = {"ATHENIAN POLITICS", "SPARTAN POLITICS", "THEBAN POLITICS", "MACEDONIAN POLITICS", "KNOSSIAN POLITICS"};
        Label polheaders[] = new Label[5];
        StackPane pollabelspane = new StackPane();
        var polscene = new Scene(polmain, 750, 657);
        Image polimgs[] = new Image[polheadercontents.length];
        ImageView polimgsview[] = new ImageView[polheadercontents.length];
        StackPane polimgpane = new StackPane();
        ScrollPane polmainarticle[] = new ScrollPane[polheaders.length];
        StackPane polarticlespane = new StackPane();
        TextFlow polarticles[] = new TextFlow[polheaders.length];
        Button polback = new Button("Back");
        StackPane polbackwrap = new StackPane();


        polarticles[0] = new TextFlow(new Text("Athenian democracy developed around the 6th century BC in the Greek city-state (known as a polis) of Athens, comprising the city of Athens and the surrounding territory of Attica. Although Athens is the most famous ancient Greek democratic city-state, it was not the only one, nor was it the first; multiple other city-states adopted similar democratic constitutions before Athens.\n\nAthens practiced a political system of legislation and executive bills. Participation was open to adult, male citizens (i.e., not a foreign resident, regardless of how many generations of the family had lived in the city, nor a slave, nor a woman), who \"were probably no more than 30 percent of the total adult population\".\n\nThere were three political bodies where citizens gathered in numbers running into the hundreds or thousands. These are the assembly (in some cases with a quorum of 6000), the council of 500 (boule), and the courts (a minimum of 200 people, on some occasions up to 6,000). Of these three bodies, the assembly and the courts were the true sites of power – although courts, unlike the assembly, were never simply called the demos ('the people'), as they were manned by just those citizens over thirty. Crucially, citizens voting in both were not subject to review and prosecution, as were council members and all other officeholders. In the 5th century BC, there is often a record of the assembly sitting as a court of judgment itself for trials of political importance and it is not a coincidence that 6,000 is the number both for the full quorum for the assembly and for the annual pool from which jurors were picked for particular trials. By the mid-4th century, however, the assembly's judicial functions were largely curtailed, though it always kept a role in the initiation of various kinds of political trial.\n\nThe central events of the Athenian democracy were the meetings of the assembly (ἐκκλησία, ekklesía). Unlike a parliament, the assembly's members were not elected, but attended by right when they chose. Greek democracy created at Athens was direct, rather than representative: any adult male citizen over the age of 20 could take part, and it was a duty to do so. The officials of the democracy were in part elected by the Assembly and in large part chosen by lottery in a process called sortition.\n\nThe assembly had four main functions: it made executive pronouncements (decrees, such as deciding to go to war or granting citizenship to a foreigner), elected some officials, legislated, and tried political crimes. As the system evolved, the last function was shifted to the law courts. The standard format was that of speakers making speeches for and against a position, followed by a general vote (usually by show of hands) of yes or no. Though there might be blocs of opinion, sometimes enduring, on important matters, there were no political parties and likewise no government or opposition. Voting was by simple majority. In the 5th century at least, there were scarcely any limits on the power exercised by the assembly. If the assembly broke the law, the only thing that might happen is that it would punish those who had made the proposal that it had agreed to. If a mistake had been made, from the assembly's viewpoint it could only be because it had been misled.\n\nVoting was usually by show of hands (χειροτονία, kheirotonia, 'arm stretching') with officials judging the outcome by sight. This could cause problems when it became too dark to see properly. However, any member could demand that officials issue a recount. For a small category of votes, a quorum of 6,000 was required, principally grants of citizenship, and here small coloured stones were used, white for yes and black for no. At the end of the session, each voter tossed one of these into a large clay jar which was afterwards cracked open for the counting of the ballots. Ostracism required the voters to scratch names onto pieces of broken pottery (ὄστρακα, ostraka), though this did not occur within the assembly as such.\n\nIn 594 BC, Solon is said to have created a boule of 400 to guide the work of the assembly. After the reforms of Cleisthenes, the Athenian Boule was expanded to 500 and was elected by lot every year. Each of Cleisthenes's 10 tribes provided 50 councilors who were at least 30 years old. The Boule's roles in public affairs included finance, maintaining the military's cavalry and fleet of ships, advising the generals, approving of newly elected magistrates, and receiving ambassadors. Most importantly, the Boule would draft probouleumata, or deliberations for the Ecclesia to discuss and approve on. During emergencies, the Ecclesia would also grant special temporary powers to the Boule.\n\nCleisthenes restricted the Boule's membership to those of zeugitai status (and above), presumably because these classes' financial interests gave them an incentive towards effective governance. A member had to be approved by his deme, each of which would have an incentive to select those with experience in local politics and the greatest likelihood at effective participation in government. The members from each of the ten tribes in the Boule took it in turns to act as a standing committee (the prytaneis) of the Boule for a period of thirty-six days. All fifty members of the prytaneis on duty were housed and fed in the tholos of the Prytaneion, a building adjacent to the bouleuterion, where the boule met. A chairman for each tribe was chosen by lot each day, who was required to stay in the tholos for the next 24 hours, presiding over meetings of the Boule and Assembly.\n\nThe boule also served as an executive committee for the assembly, and oversaw the activities of certain other magistrates. The boule coordinated the activities of the various boards and magistrates that carried out the administrative functions of Athens and provided from its own membership randomly selected boards of ten responsible for areas ranging from naval affairs to religious observances. Altogether, the boule was responsible for a great portion of the administration of the state, but was granted relatively little latitude for initiative; the boule's control over policy was executed in its probouleutic, rather than its executive function; in the former, it prepared measures for deliberation by the assembly, in the latter, it merely executed the wishes of the assembly.\n\nAthens had an elaborate legal system centered on full citizen rights.The age limit of 30 or older, the same as that for office holders but ten years older than that required for participation in the assembly, gave the courts a certain standing in relation to the assembly. Jurors were required to be under oath, which was not required for attendance at the assembly. The authority exercised by the courts had the same basis as that of the assembly: both were regarded as expressing the direct will of the people. Unlike office holders (magistrates), who could be impeached and prosecuted for misconduct, the jurors could not be censured, for they, in effect, were the people and no authority could be higher than that. A corollary of this was that, at least acclaimed by defendants, if a court had made an unjust decision, it must have been because it had been misled by a litigant. Essentially there were two grades of a suit, a smaller kind known as dike (δίκη) or private suit, and a larger kind known as graphe or public suit. For private suits, the minimum jury size was 200 (increased to 401 if a sum of over 1000 drachmas was at issue), for public suits 501. Under Cleisthenes's reforms, juries were selected by lot from a panel of 600 jurors, there being 600 jurors from each of the ten tribes of Athens, making a jury pool of 6000 in total. For particularly important public suits the jury could be increased by adding in extra allotments of 500. 1000 and 1500 are regularly encountered as jury sizes and on at least one occasion, the first time a new kind of case was brought to court (see graphē paranómōn), all 6,000 members of the jury pool may have attended to one case.\n\nThe cases were put by the litigants themselves in the form of an exchange of single speeches timed by a water clock or clepsydra, first prosecutor then defendant. In a public suit the litigants each had three hours to speak, much less in private suits (though here it was in proportion to the amount of money at stake). Decisions were made by voting without any time set aside for deliberation. Jurors did talk informally amongst themselves during the voting procedure and juries could be rowdy, shouting out their disapproval or disbelief of things said by the litigants. This may have had some role in building a consensus. The jury could only cast a 'yes' or 'no' vote as to the guilt and sentence of the defendant. For private suits only the victims or their families could prosecute, while for public suits anyone (ho boulomenos, 'whoever wants to' i.e. any citizen with full citizen rights) could bring a case since the issues in these major suits were regarded as affecting the community as a whole. Justice was rapid: a case could last no longer than one day and had to be completed by the time the sun set. Some convictions triggered an automatic penalty, but where this was not the case the two litigants each proposed a penalty for the convicted defendant and the jury chose between them in a further vote. No appeal was possible. There was however a mechanism for prosecuting the witnesses of a successful prosecutor, which it appears could lead to the undoing of the earlier verdict."));
        polarticles[1] = new TextFlow(new Text("The Spartans had no historical records, literature, or written laws, which were, according to tradition, expressly prohibited by an ordinance of Lycurgus, excluding the Great Rhetra. According to Plutarch, Lycurgus (to whom is attributed the establishment of the severe reforms for which Sparta has become renowned, sometime in the 9th century BC) first sought counsel from the god Apollo by obtaining an oracle from Delphi regarding the formation of his government. The divine proclamation, which he received in this manner, is known as a \"rhetra\" and is given in part by Plutarch as follows: \"When thou hast built a temple to Zeus Syllanius and Athena Syllania, divided the people into 'phylai' and into 'obai', and established a senate of thirty members, including the 'archagetai', then from time to time 'appellazein' between Babyca and Cnacion, and there introduce and rescind measures; but the people must have the deciding voice and the power.\"\n\nIssuance of coinage was forbidden. Spartans were obliged to use iron obols (bars or spits), meant to encourage self-sufficiency and discourage avarice and the hoarding of wealth. Women had no formal political rights, but they were expected to speak their minds boldly and their opinions were heard.\n\nSpartan society can be broken up in the following 3 social classes: the Spartiates, the Perioikoi and the Helots.\n\nSpartiates were full citizens of the Spartan state (or part of the demos). Most inhabitants of Sparta were not considered citizens. Only those who had successfully undertaken military training, called the agoge, and who were members in good standing of syssitia (mess hall), were eligible. Usually, the only people eligible to receive the agoge were sons of Spartiate—men who could trace their ancestry to the original inhabitants of the city. There were two exceptions to this rule. Trophimoi (\"foster sons\") were foreign teenagers invited to study. This was meant as a supreme honor. The pro-Spartan Athenian magnate Xenophon sent his two sons to Sparta for their education as trophimoi. Alcibiades, being an Alcmaeonid and thus a member of a family with old and strong connections to Sparta, was admitted as a trophimos and famously excelled in the agoge as well as otherwise . The other exception was that sons of helots could be enrolled as syntrophoi (comrades, literally \"the ones fed, or reared, together\") if a Spartiate formally adopted him and paid his way. A free-born Spartan who had successfully completed the agoge became a \"peer\" (ὅμοιος, hómoios, literally \"similar\") with full civil rights at the age of 20, and remained one as long as he could contribute his equal share of grain to the syssitia, a common military mess in which he was obliged to dine every evening for as long as he was battle-worthy (usually until the age of 60). The hómoioi were also required to sleep in the barracks until the age of 30, regardless of whether they were married or not.\n\nOthers in the state were the Perioeci or Períoikoi, a social class and population group of non-citizen inhabitants. The Perioeci were free, unlike the helots, but were not full Spartan citizens. They had a central role in the Spartan economy, controlling commerce and business, as well as being responsible for crafts and manufacturing.\n\nHelots were the state-owned serfs who made up 90 percent of the population. They were citizens of conquered states, such as Messenia who were conquered for their fertile land during the First Messenian War.\n\nWhen it comes to the government itself, things were a bit more complicated. The Doric state of Sparta, copying the Doric Cretans, instituted a mixed governmental state: it was composed of elements of monarchical, oligarchical, and democratic systems. Isocrates refers to the Spartans as \"subject to an oligarchy at home, to a kingship on campaign\".\n\nThe state was ruled by two hereditary kings of the Agiad and the Eurypontid families, both descendants of Heracles and equal in authority so that one could not act against the power and political enactments of his colleague, though the Agiad king received greater honour by virtue of seniority of his family for being the \"oldest extant\" There are several legendary explanations for this unusual dual kingship, which differ only slightly; for example, that King Aristodemus had twin sons, who agreed to share the kingship, and this became perpetual. Modern scholars have advanced various theories to account for the anomaly. Some theorize that this system was created in order to prevent absolutism, and is paralleled by the analogous instance of the dual consuls of Rome. Others believe that it points to a compromise arrived at to end the struggle between two families or communities. Other theories suggest that this was an arrangement that was met when a community of villages combined to form the city of Sparta. Subsequently the two chiefs from the largest villages became kings. Either way, kingship in Sparta was hereditary and thus every king Sparta had was a descendant of the Agiad and the Eurypontid families. Accession was given to the male child who was first born after a king's accession.\n\nThe duties of the kings were primarily religious, judicial, and militaristic. They were the chief priests of the state, and performed certain sacrifices and also maintained communication with the Delphic sanctuary, which always exercised great authority in Spartan politics. In the time of Herodotus (about 450 BC), their judicial functions had been restricted to cases dealing with heiresses, adoptions and the public roads. Civil cases were decided by the ephors, and criminal jurisdiction had been passed to the ephors, as well as to a council of elders. By 500 BC the Spartans had become increasingly involved in the political affairs of the surrounding city-states, often putting their weight behind pro-Spartan candidates. Shortly before 500 BC, as described by Herodotus, such an action fueled a confrontation between Sparta and Athens, when the two kings, Demaratus and Cleomenes, took their troops to Athens. However, just before the heat of battle, King Demaratus changed his mind about attacking the Athenians and abandoned his co-king. For this reason, Demaratus was banished, and eventually found himself at the side of Persian King Xerxes for his invasion of Greece twenty years later (480 BC), after which the Spartans enacted a law demanding that one king remain behind in Sparta while the other commanded the troops in battle. Dating from the period of the Persian wars, the king lost the right to declare war, and was accompanied in the field by two ephors. He was supplanted also by the ephors in the control of foreign policy. Over time, the kings became mere figureheads except in their capacity as generals. Real power was transferred to the ephors and to the gerousia.\n\nThe ephors, chosen by popular election from the whole body of citizens, represented a democratic element in the constitution. After the ephors were introduced, they, together with the two kings, were the executive branch of the state. Ephors themselves had more power than anyone in Sparta, although the fact that they only stayed in power for a single year reduced their ability to conflict with already established powers in the state. Since reelection was not possible, an ephor who abused his power, or confronted an established power center, would have to suffer retaliation. Although the five ephors were the only officials with regular legitimization by popular vote, in practice they were often the most conservative force in Spartan politics.\n\nSparta had a special policy maker, the gerousia, a council consisting of 28 elders over the age of 60, elected for life and usually part of the royal households, and the two kings. High state policy decisions were discussed by this council who could then propose action alternatives to the demos.\n\nThe collective body of Spartan citizenry would select one of the alternatives by voting. Unlike most Greek poleis, the Spartan citizen assembly could neither set the agenda of issues to be decided, nor debate them, merely vote on the alternatives presented to them. Neither could foreign embassies or emissaries address the assembly; they had to present their case to the Gerousia, which would then consult with the Ephors. Sparta considered all discourse from outside as a potential threat and all other states as past, present, or future enemies, to be treated with caution in the very least, even when bound with alliance treaties."));
        polarticles[2] = new TextFlow(new Text(null));    //Unnecessary, used for keeping numbering proper
        polarticles[3] = new TextFlow(new Text("The earliest government of Macedonia was established by the Argead dynasty of Macedonian kings some time during the period of Archaic Greece (8th–5th centuries BC). Due to shortcomings in the historical record, very little is known about the origins of Macedonian governmental institutions before the reign of Philip II of Macedon (r. 359–336 BC), during the final phase of Classical Greece (480–336 BC).\n\nIt is unclear if there was a formally established constitution dictating the laws, organization, and divisions of power in ancient Macedonia's government, although some tangential evidence suggests this. The king (basileus) served as the head of state and was assisted by his noble companions and royal pages. Kings served as the chief judges of the kingdom, although little is known about Macedonia's judiciary. The kings were also expected to serve as high priests of the nation, using their wealth to sponsor various religious cults. The Macedonian kings had command over certain natural resources such as gold from mining and timber from logging. The right to mint gold, silver, and bronze coins was shared by the central and local governments. The Macedonian kings served as the commanders-in-chief of Macedonia's armed forces, while it was common for them to personally lead troops into battle. Surviving textual evidence suggests that the ancient Macedonian army exercised its authority in matters such as the royal succession when there was no clear heir apparent to rule the kingdom. The army upheld some of the functions of a popular assembly, a democratic institution which otherwise existed in only a handful of municipal governments within the Macedonian commonwealth: the Koinon of Macedonians. With their mining and tax revenues, the kings were responsible for funding the military, which included a navy that was established by Philip II and expanded during the Antigonid period."));
        polarticles[4] = new TextFlow(new Text("Very little is known about the forms of Minoan government; the Minoan language has not yet been deciphered. It used to be believed that the Minoans had a monarchy supported by a bureaucracy. This might initially have been a number of monarchies, corresponding with the \"palaces\" around Crete, but later all taken over by Knossos, which was itself later occupied by Mycenaean overlords. But, in notable contrast to contemporary Egyptian and Mesopotamian civilizations, \"Minoan iconography contains no pictures of recognizable kings\", and in recent decades it has come be thought that before the presumed Mycenaean invasion around 1450, a group of elite families, presumably living in the \"villas\" and the palaces, controlled both government and religion"));

        for(int i = 0 ; i < polimgs.length; i++)
        {
            polmainarticle[i] = new ScrollPane();
            polmainarticle[i].setVisible(false);
            polmainarticle[i].setContent(polarticles[i]);
            polmainarticle[i].setFitToWidth(true);
            polmainarticle[i].setHbarPolicy(ScrollBarPolicy.NEVER);
            polmainarticle[i].setPrefHeight(200);
            polmainarticle[i].setPadding(new Insets(5, 5, 5, 5));
            polarticlespane.getChildren().add(polmainarticle[i]);
        }

        polarticlespane.setPadding(new Insets(25, 5, 25, 5));

        polimgs[0] = new Image("file:Images/AthenianPolitics.png", 400, 250, false, false);
        polimgs[1] = new Image("file:Images/SpartanPolitics.jpg", 400, 250, false, false);
        polimgs[2] = new Image("file:Images/ThebesPhalanx.jpg", 400, 250, false, false);    //Unnecessary, used for keeping numbering proper
        polimgs[3] = new Image("file:Images/MacedonPhalanx.png", 400, 250, false, false);
        polimgs[4] = new Image("file:Images/KnossianPolitics.jpg", 400, 250, false, false);

        for(int i = 0 ; i < polimgs.length; i++)
        {
            polimgsview[i] = new ImageView(polimgs[i]);
        }

        for(int i = 0 ; i < polimgs.length; i++)
        {
            polimgpane.getChildren().add(polimgsview[i]);
            polimgsview[i].setVisible(false);
        }
        polimgpane.setPadding(new Insets(0, 30, 25, 30));

        for(int i = 0 ; i < polheaders.length ; i++)
        {
            polheaders[i] = new Label(polheadercontents[i]);
            polheaders[i].setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 50));
            polheaders[i].setVisible(false);
        }

        for(int i = 0 ; i < polheaders.length ; i++)
        {
            pollabelspane.getChildren().add(polheaders[i]);
        }

        polback.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 20));    
        polbackwrap.getChildren().add(polback);
        polbackwrap.setAlignment(Pos.BOTTOM_CENTER);
        polbackwrap.setPadding(new Insets(0, 0, 10, 0));

        polmain.getChildren().addAll(pollabelspane, polimgpane, polarticlespane, polbackwrap);

        //
        //
        //Culture scene
        //
        //
        VBox culmain = new VBox();
        String culheadercontents[] = {"ATHENIAN CULTURE", "SPARTAN CULTURE", "THEBAN CULTURE", "MACEDONIAN CULTURE", "KNOSSIAN CULTURE"};
        Label culheaders[] = new Label[5];
        StackPane cullabelspane = new StackPane();
        var culscene = new Scene(culmain, 750, 657);
        Image culimgs[] = new Image[culheadercontents.length];
        ImageView culimgsview[] = new ImageView[culheadercontents.length];
        StackPane culimgpane = new StackPane();
        ScrollPane culmainarticle[] = new ScrollPane[culheaders.length];
        StackPane cularticlespane = new StackPane();
        TextFlow cularticles[] = new TextFlow[culheaders.length];
        Button culback = new Button("Back");
        StackPane culbackwrap = new StackPane();


        cularticles[0] = new TextFlow(new Text("The Ancient Athenians were peaceful, they enjoyed the systematic study of subjects such as science, philosophy, and history. They also loved art, architecture and literature, and they created thousands of temples, statues, paintings and texts. Today the Athenians’ style of art and architecture is referred to as classical. A famous example of the Athenians' architectural style is the Parthenon.\n\nTheir love for different arts attracted many visitors and also famous writers, sculptors, architects and playwrights. Due to all these visitors and also people settling down soon Athens was full of people. Outside of military training and politics, most Athenians enjoyed watching plays at the theatre. This included tragedies, comedies and other sorts of plays. Because of the focus on education in Athens(for men at least, women did not receive an education), a lot of famous writers, artists, and philosophers ended up living in Athens. Some philosophers also had schools of their own and they taught people their ideas and beliefs. Athens also had many mathematicians and astronomers. From those people we have learned about geometry, atoms, other planets, earth is a globe, physics and mathematics. After the Persian wars, under the rule of Pericles, the Golden Age of Athens began. Athens prospered as a center of art and learning and the people created many new statues, temples, and schools."));
        cularticles[1] = new TextFlow(new Text("Spartan culture was centered on loyalty to the state and military service. At age 7, Spartan boys entered a rigorous state-sponsored education, military training and socialization program. Known as the Agoge (which we have further analyzed in the military section for Sparta), the system emphasized duty, discipline and endurance. Although Spartan women were not active in the military, they were educated and enjoyed more status and freedom than other Greek women. Because Spartan men were professional soldiers, all manual labor was done by a slave class, the Helots. Spartans were also quite known for the way they spoke, namely Laconic speech.\n\nSpartans paid less attention than other ancient Greeks to the development of education, arts, and literature. Some view this as having contributed to the characteristically blunt Laconian speech. However, Socrates, in Plato's dialogue Protagoras, appears to reject the idea that Spartans' economy with words was simply a consequence of poor literary education: \"... they conceal their wisdom, and pretend to be blockheads, so that they may seem to be superior only because of their prowess in battle ... This is how you may know that I am speaking the truth and that the Spartans are the best educated in philosophy and speaking: if you talk to any ordinary Spartan, he seems to be stupid, but eventually, like an expert marksman, he shoots in some brief remark that proves you to be only a child\". In general, however, Spartans were expected to be men of few words, to hold rhetoric in disdain, and to stick to the point. Loquacity was considered frivolous and unbecoming of sensible, down-to-earth Spartan warriors. A Spartan youth was reportedly liable to have his thumb bitten as punishment for too verbose a response to a teacher's question. Due to the fact that Spartans did not keep written historical records or literature, not much is known about their culture, other than it was focused on producing excellent warriors."));
        cularticles[2] = new TextFlow(new Text(null));    //Unnecessary, used for keeping numbering proper
        cularticles[3] = new TextFlow(new Text("Macedonia had a distinct material culture by the Early Iron Age. Typically Balkan burial, ornamental, and ceramic forms were used for most of the Iron Age. These features suggest broad cultural affinities and organizational structures analogous with Thracian, Epirote, and Illyrian regions. This did not necessarily symbolize a shared cultural identity, or any political allegiance between these regions. In the late sixth century BC, Macedonia became open to south Greek influences, although a small but detectable amount of interaction with the south had been present since late Mycenaean times. By the 5th century BC, Macedonia was a part of the \"Greek cultural milieu\" according to Edward M. Anson, possessing many cultural traits typical of the southern Greek city-states. Classical Greek objects and customs were appropriated selectively and used in peculiarly Macedonian ways. In addition, influences from Achaemenid Persia in culture and economy are evident from the 5th century BC onward, such as the inclusion of Persian grave goods at Macedonian burial sites as well as the adoption of royal customs such as a Persian-style throne during the reign of Philip II.\n\nBy the reign of Archelaus I of Macedon, the Macedonian elite started importing significantly greater customs, artwork, and art traditions from other regions of Greece. However, they still retained more archaic, perhaps Homeric funerary rites connected with the symposium and drinking rites that were typified with items such as decorative metal kraters that held the ashes of deceased Macedonian nobility in their tombs. Surviving Macedonian painted artwork includes frescoes and murals on walls, but also decoration on sculpted artwork such as statues and reliefs. Aside from metalwork and painting, mosaics serve as another significant form of surviving Macedonian artwork, especially those discovered at Pella dating to the 4th century BC. Music was also appreciated in Macedonia. In addition to the agora, the gymnasium, the theatre, and religious sanctuaries and temples dedicated to Greek gods and goddesses, one of the main markers of a true Greek city in the empire of Alexander the Great was the presence of an odeon for musical performances."));
        cularticles[4] = new TextFlow(new Text("Minoan art is marked by imaginative images and exceptional workmanship. Sinclair Hood described an \"essential quality of the finest Minoan art, the ability to create an atmosphere of movement and life although following a set of highly formal conventions\". It forms part of the wider grouping of Aegean art, and in later periods came for a time to have a dominant influence over Cycladic art. Wood and textiles have decomposed, so most surviving examples of Minoan art are pottery, intricately-carved Minoan seals, palace frescos which include landscapes (but are often mostly \"reconstructed\"), small sculptures in various materials, jewellery, and metalwork.\n\nMinoan art has a variety of subject-matter, much of it appearing across different media, although only some styles of pottery include figurative scenes. Bull-leaping appears in painting and several types of sculpture, and is thought to have had a religious significance; bull's heads are also a popular subject in terracotta and other sculptural materials. There are no figures that appear to be portraits of individuals, or are clearly royal, and the identities of religious figures is often tentative, with scholars uncertain whether they are deities, clergy or devotees. Equally, whether painted rooms were \"shrines\" or secular is far from clear; one room in Akrotiri has been argued to be a bedroom, with remains of a bed, or a shrine. Animals, including an unusual variety of marine fauna, are often depicted. The Cretans also appear to have utilized many different styles of potted wares and techniques of production."));

        for(int i = 0 ; i < culimgs.length; i++)
        {
            culmainarticle[i] = new ScrollPane();
            culmainarticle[i].setVisible(false);
            culmainarticle[i].setContent(cularticles[i]);
            culmainarticle[i].setFitToWidth(true);
            culmainarticle[i].setHbarPolicy(ScrollBarPolicy.NEVER);
            culmainarticle[i].setPrefHeight(200);
            culmainarticle[i].setPadding(new Insets(5, 5, 5, 5));
            cularticlespane.getChildren().add(culmainarticle[i]);
        }

        cularticlespane.setPadding(new Insets(25, 5, 25, 5));

        culimgs[0] = new Image("file:Images/AthensCulture.jpg", 400, 250, false, false);
        culimgs[1] = new Image("file:Images/SpartanCulture .jpg", 400, 250, false, false);
        culimgs[2] = new Image("file:Images/ThebesPhalanx.jpg", 400, 250, false, false);    //Unnecessary, used for keeping numbering proper
        culimgs[3] = new Image("file:Images/MacedonCulture.jpg", 400, 250, false, false);
        culimgs[4] = new Image("file:Images/KnossosCulture.jpg", 400, 250, false, false);

        for(int i = 0 ; i < culimgs.length; i++)
        {
            culimgsview[i] = new ImageView(culimgs[i]);
        }

        for(int i = 0 ; i < culimgs.length; i++)
        {
            culimgpane.getChildren().add(culimgsview[i]);
            culimgsview[i].setVisible(false);
        }
        culimgpane.setPadding(new Insets(0, 30, 25, 30));

        for(int i = 0 ; i < culheaders.length ; i++)
        {
            culheaders[i] = new Label(culheadercontents[i]);
            culheaders[i].setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 50));
            culheaders[i].setVisible(false);
        }

        for(int i = 0 ; i < culheaders.length ; i++)
        {
            cullabelspane.getChildren().add(culheaders[i]);
        }

        culback.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 20));    
        culbackwrap.getChildren().add(culback);
        culbackwrap.setAlignment(Pos.BOTTOM_CENTER);
        culbackwrap.setPadding(new Insets(0, 0, 10, 0));

        culmain.getChildren().addAll(cullabelspane, culimgpane, cularticlespane, culbackwrap);



        //Help Button
        help.setFont(Font.loadFont("file:fonts/DIOGENES.ttf", 30));
        help.getStyleClass().add("help");
        help.setOnAction((e) -> {
            Dialog<String> dialog = new Dialog<>();
            dialog.initOwner(stage);
            dialog.initModality(Modality.NONE);
            dialog.setTitle("Help");
            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
            dialog.setResizable(false);
            dialog.getDialogPane().setMaxSize(300, 300);
            HBox mainpoppane = new HBox();
            ImageView img1 = new ImageView(city);
            Text text1 = new Text("To use this app, simply hover your mouse over the following icon: ");
            Text text2 = new Text("\n\nUpon doing so, the icon will change color to white. At that point, you can click on the icon to get more information about that city-state.\n\n The currently implemented city-states are: Athens, Sparta, Thebes, Pella and Knossos.");
            TextFlow text3 = new TextFlow(text1, img1, text2);

            mainpoppane.getChildren().addAll(text3);
            dialog.getDialogPane().setContent(mainpoppane);
            dialog.showAndWait();
        });


        //Content Table
        contentstable.setLayoutX(20);
        contentstable.setLayoutY(560);
        contentstable.getChildren().addAll(help);


        //Main Pane
        mainp.setBackground(new Background(bg));
        mainp.getChildren().add(contentstable);
        mainp.getChildren().add(Athens);
        mainp.getChildren().add(AthensHover);
        mainp.getChildren().add(Sparta);
        mainp.getChildren().add(SpartaHover);
        mainp.getChildren().add(Thebes);
        mainp.getChildren().add(ThebesHover);
        mainp.getChildren().add(Pella);
        mainp.getChildren().add(PellaHover);
        mainp.getChildren().add(Knossos);
        mainp.getChildren().add(KnossosHover);

        //Athens on map
        Athens.setLayoutX(328);
        Athens.setLayoutY(330);
        Athens.setPickOnBounds(true);
        AthensHover.setLayoutX(326);
        AthensHover.setLayoutY(330);
        AthensHover.setVisible(false);
        Athens.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Athens.setVisible(false);
                AthensHover.setVisible(true);
            }
            else
            {
               Athens.setVisible(true);
               AthensHover.setVisible(false);  
            }
        });
        AthensHover.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Athens.setVisible(false);
                AthensHover.setVisible(true);
            }
            else
            {
               Athens.setVisible(true);
               AthensHover.setVisible(false);  
            }
        });

        AthensHover.setOnMouseClicked((e) -> {
            headers[0].setVisible(true);
            stage.setScene(scene_secondary);
            stage.show();
            if(headers[0].isVisible())
            {
                militarybutton.setOnAction((event) -> {
                    milheaders[0].setVisible(true);
                    milimgsview[0].setVisible(true);
                    mainarticle[0].setVisible(true);
                    stage.setScene(milscene);
                    stage.show();
                    milback.setOnAction((event1) -> {
                        milheaders[0].setVisible(false);
                        milimgsview[0].setVisible(false);
                        mainarticle[0].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                historybutton.setOnAction((event) -> {
                    hisheaders[0].setVisible(true);
                    hisimgsview[0].setVisible(true);
                    hismainarticle[0].setVisible(true);
                    stage.setScene(hisscene);
                    stage.show();
                    hisback.setOnAction((event1) -> {
                        hisheaders[0].setVisible(false);
                        hisimgsview[0].setVisible(false);
                        hismainarticle[0].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                politicsbutton.setOnAction((event) -> {
                    polheaders[0].setVisible(true);
                    polimgsview[0].setVisible(true);
                    polmainarticle[0].setVisible(true);
                    stage.setScene(polscene);
                    stage.show();
                    polback.setOnAction((event1) -> {
                        polheaders[0].setVisible(false);
                        polimgsview[0].setVisible(false);
                        polmainarticle[0].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                culturebutton.setOnAction((event) -> {
                    culheaders[0].setVisible(true);
                    culimgsview[0].setVisible(true);
                    culmainarticle[0].setVisible(true);
                    stage.setScene(culscene);
                    stage.show();
                    culback.setOnAction((event1) -> {
                        culheaders[0].setVisible(false);
                        culimgsview[0].setVisible(false);
                        culmainarticle[0].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
            }
            back.setOnAction((event) -> {
                headers[0].setVisible(false);
                stage.setScene(scene);
                stage.show();
            });
        });

        //Sparta on map
        Sparta.setLayoutX(232);
        Sparta.setLayoutY(408);
        Sparta.setPickOnBounds(true);
        SpartaHover.setLayoutX(230);
        SpartaHover.setLayoutY(408);
        SpartaHover.setVisible(false);
        Sparta.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Sparta.setVisible(false);
                SpartaHover.setVisible(true);
            }
            else
            {
               Sparta.setVisible(true);
               SpartaHover.setVisible(false);  
            }
        });
        SpartaHover.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Sparta.setVisible(false);
                SpartaHover.setVisible(true);
            }
            else
            {
                Sparta.setVisible(true);
                SpartaHover.setVisible(false);  
            }
        });

        SpartaHover.setOnMouseClicked((e) -> {
            headers[1].setVisible(true);
            stage.setScene(scene_secondary);
            stage.show();
            if(headers[1].isVisible())
            {
                militarybutton.setOnAction((event) -> {
                    milheaders[1].setVisible(true);
                    milimgsview[1].setVisible(true);
                    mainarticle[1].setVisible(true);
                    stage.setScene(milscene);
                    stage.show();
                    milback.setOnAction((event1) -> {
                        milheaders[1].setVisible(false);
                        milimgsview[1].setVisible(false);
                        mainarticle[1].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                historybutton.setOnAction((event) -> {
                    hisheaders[1].setVisible(true);
                    hisimgsview[1].setVisible(true);
                    hismainarticle[1].setVisible(true);
                    stage.setScene(hisscene);
                    stage.show();
                    hisback.setOnAction((event1) -> {
                        hisheaders[1].setVisible(false);
                        hisimgsview[1].setVisible(false);
                        hismainarticle[1].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                politicsbutton.setOnAction((event) -> {
                    polheaders[1].setVisible(true);
                    polimgsview[1].setVisible(true);
                    polmainarticle[1].setVisible(true);
                    stage.setScene(polscene);
                    stage.show();
                    polback.setOnAction((event1) -> {
                        polheaders[1].setVisible(false);
                        polimgsview[1].setVisible(false);
                        polmainarticle[1].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                culturebutton.setOnAction((event) -> {
                    culheaders[1].setVisible(true);
                    culimgsview[1].setVisible(true);
                    culmainarticle[1].setVisible(true);
                    stage.setScene(culscene);
                    stage.show();
                    culback.setOnAction((event1) -> {
                        culheaders[1].setVisible(false);
                        culimgsview[1].setVisible(false);
                        culmainarticle[1].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
            }
            back.setOnAction((event) -> {
                headers[1].setVisible(false);
                stage.setScene(scene);
                stage.show();
            });
        });

        //Thebes on map
        Thebes.setLayoutX(302);
        Thebes.setLayoutY(305);
        Thebes.setPickOnBounds(true);
        ThebesHover.setLayoutX(300);
        ThebesHover.setLayoutY(305);
        ThebesHover.setVisible(false);
        Thebes.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Thebes.setVisible(false);
                ThebesHover.setVisible(true);
            }
            else
            {
               Thebes.setVisible(true);
               ThebesHover.setVisible(false);  
            }
        });
        ThebesHover.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Thebes.setVisible(false);
                ThebesHover.setVisible(true);
            }
            else
            {
                Thebes.setVisible(true);
                ThebesHover.setVisible(false);  
            }
        });

        ThebesHover.setOnMouseClicked((e) -> {
            headers[2].setVisible(true);
            stage.setScene(scene_secondary);
            stage.show();
            if(headers[2].isVisible())
            {
                militarybutton.setOnAction((event) -> {
                    milheaders[2].setVisible(true);
                    milimgsview[2].setVisible(true);
                    mainarticle[2].setVisible(true);
                    stage.setScene(milscene);
                    stage.show();
                    milback.setOnAction((event1) -> {
                        milheaders[2].setVisible(false);
                        milimgsview[2].setVisible(false);
                        mainarticle[2].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                historybutton.setOnAction((event) -> {
                    hisheaders[2].setVisible(true);
                    hisimgsview[2].setVisible(true);
                    hismainarticle[2].setVisible(true);
                    stage.setScene(hisscene);
                    stage.show();
                    hisback.setOnAction((event1) -> {
                        hisheaders[2].setVisible(false);
                        hisimgsview[2].setVisible(false);
                        hismainarticle[2].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
            }
            politicsbutton.setDisable(true);
            culturebutton.setDisable(true);
            back.setOnAction((event) -> {
                headers[2].setVisible(false);
                stage.setScene(scene);
                stage.show();
                politicsbutton.setDisable(false);
                culturebutton.setDisable(false);
            });
        });

        //Pella on map
        Pella.setLayoutX(231);
        Pella.setLayoutY(78);
        Pella.setPickOnBounds(true);
        PellaHover.setLayoutX(229);
        PellaHover.setLayoutY(78);
        PellaHover.setVisible(false);
        Pella.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Pella.setVisible(false);
                PellaHover.setVisible(true);
            }
            else
            {
                Pella.setVisible(true);
               PellaHover.setVisible(false);  
            }
        });
        PellaHover.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Pella.setVisible(false);
                PellaHover.setVisible(true);
            }
            else
            {
                Pella.setVisible(true);
                PellaHover.setVisible(false);  
            }
        });

        PellaHover.setOnMouseClicked((e) -> {
            headers[3].setVisible(true);
            stage.setScene(scene_secondary);
            stage.show();
            if(headers[3].isVisible())
            {
                militarybutton.setOnAction((event) -> {
                    milheaders[3].setVisible(true);
                    milimgsview[3].setVisible(true);
                    mainarticle[3].setVisible(true);
                    stage.setScene(milscene);
                    stage.show();
                    milback.setOnAction((event1) -> {
                        milheaders[3].setVisible(false);
                        milimgsview[3].setVisible(false);
                        mainarticle[3].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                historybutton.setOnAction((event) -> {
                    hisheaders[3].setVisible(true);
                    hisimgsview[3].setVisible(true);
                    hismainarticle[3].setVisible(true);
                    stage.setScene(hisscene);
                    stage.show();
                    hisback.setOnAction((event1) -> {
                        hisheaders[3].setVisible(false);
                        hisimgsview[3].setVisible(false);
                        hismainarticle[3].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                politicsbutton.setOnAction((event) -> {
                    polheaders[3].setVisible(true);
                    polimgsview[3].setVisible(true);
                    polmainarticle[3].setVisible(true);
                    stage.setScene(polscene);
                    stage.show();
                    polback.setOnAction((event1) -> {
                        polheaders[3].setVisible(false);
                        polimgsview[3].setVisible(false);
                        polmainarticle[3].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                culturebutton.setOnAction((event) -> {
                    culheaders[3].setVisible(true);
                    culimgsview[3].setVisible(true);
                    culmainarticle[3].setVisible(true);
                    stage.setScene(culscene);
                    stage.show();
                    culback.setOnAction((event1) -> {
                        culheaders[3].setVisible(false);
                        culimgsview[3].setVisible(false);
                        culmainarticle[3].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
            }
            back.setOnAction((event) -> {
                headers[3].setVisible(false);
                stage.setScene(scene);
                stage.show();
            });
        });

        //Knossos on map
        Knossos.setLayoutX(447);
        Knossos.setLayoutY(569);
        Knossos.setPickOnBounds(true);
        KnossosHover.setLayoutX(445);
        KnossosHover.setLayoutY(569);
        KnossosHover.setVisible(false);
        Knossos.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Knossos.setVisible(false);
                KnossosHover.setVisible(true);
            }
            else
            {
                Knossos.setVisible(true);
                KnossosHover.setVisible(false);  
            }
        });
        KnossosHover.hoverProperty().addListener((ChangeListener<Boolean>)(observable, oldValue, newValue) -> {
            if(newValue)
            {
                Knossos.setVisible(false);
                KnossosHover.setVisible(true);
            }
            else
            {
                Knossos.setVisible(true);
                KnossosHover.setVisible(false);  
            }
        });

        KnossosHover.setOnMouseClicked((e) -> {
            headers[4].setVisible(true);
            stage.setScene(scene_secondary);
            stage.show();
            if(headers[4].isVisible())
            {
                militarybutton.setOnAction((event) -> {
                    milheaders[4].setVisible(true);
                    milimgsview[4].setVisible(true);
                    mainarticle[4].setVisible(true);
                    stage.setScene(milscene);
                    stage.show();
                    milback.setOnAction((event1) -> {
                        milheaders[4].setVisible(false);
                        milimgsview[4].setVisible(false);
                        mainarticle[4].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                historybutton.setOnAction((event) -> {
                    hisheaders[4].setVisible(true);
                    hisimgsview[4].setVisible(true);
                    hismainarticle[4].setVisible(true);
                    stage.setScene(hisscene);
                    stage.show();
                    hisback.setOnAction((event1) -> {
                        hisheaders[4].setVisible(false);
                        hisimgsview[4].setVisible(false);
                        hismainarticle[4].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                politicsbutton.setOnAction((event) -> {
                    polheaders[4].setVisible(true);
                    polimgsview[4].setVisible(true);
                    polmainarticle[4].setVisible(true);
                    stage.setScene(polscene);
                    stage.show();
                    polback.setOnAction((event1) -> {
                        polheaders[4].setVisible(false);
                        polimgsview[4].setVisible(false);
                        polmainarticle[4].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
                culturebutton.setOnAction((event) -> {
                    culheaders[4].setVisible(true);
                    culimgsview[4].setVisible(true);
                    culmainarticle[4].setVisible(true);
                    stage.setScene(culscene);
                    stage.show();
                    culback.setOnAction((event1) -> {
                        culheaders[4].setVisible(false);
                        culimgsview[4].setVisible(false);
                        culmainarticle[4].setVisible(false);
                        stage.setScene(scene_secondary);
                        stage.show();
                    });
                });
            }
            back.setOnAction((event) -> {
                headers[4].setVisible(false);
                stage.setScene(scene);
                stage.show();
            });
        });

        //Main scene
        scene.getStylesheets().add("file:src/main/java/gr/uop/styles.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ancient Greece 101");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}