# Kmm-sample
Kotlin Multiplatform Mobile (KMM) sample project
#
            ┌───────────────────┐       ┌───────────────────┐
            │    Android App    │       │      Ios App      │
            │ ┌───────────────┐ │       │ ┌───────────────┐ │
            │ │JetPack Compose│ │       │ │   Swift Ui    │ │
            │ └───────────────┘ │       │ └───────────────┘ │
            │                   │       │                   │
            │ ┌───────────────┐ │       │ ┌───────────────┐ │
            │ │Specific Codes │ │       │ │Specific Codes │ │
            │ └───────────────┘ │       │ └───────────────┘ │
            │                   │       │                   │
            └─────────┬─────────┘       └─────────┬─────────┘
                      │                           │
         ┌────────────▼───────────────────────────▼────────────┐
         │                                                     │
         │ ┌──────────────┐ ┌───────────────┐ ┌──────────────┐ │
         │ │Android Domain│ │ Common Domain │ │  Ios Domain  │ │
         │ └──────────────┘ └───────────────┘ └──────────────┘ │
         │                                                     │
         └──────────────────────────┬──────────────────────────┘
                                    │
                              ┌─────▼─────┐
                              │repository │
                              └─────┬─────┘
                                    │
                              ┌─────▼─────┐
                              │  network  │
                              └───────────┘
